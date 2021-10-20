package ru.ifmo.todosApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import ru.ifmo.todosApp.domain.TodosList;
import ru.ifmo.todosApp.form.TodosListCredentials;
import ru.ifmo.todosApp.form.validator.TodosListCredentialsValidator;
import ru.ifmo.todosApp.service.TodosListService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class IndexPage extends Page {
    private static final String newTodosListCredentialsName = "newTodosListCredentials";
    private final TodosListService todosListService;
    private final TodosListCredentialsValidator todosListCredentialsValidator;

    public IndexPage(TodosListService todosListService,
                     TodosListCredentialsValidator todosListCredentialsValidator) {
        this.todosListService = todosListService;
        this.todosListCredentialsValidator = todosListCredentialsValidator;
    }

    @InitBinder(newTodosListCredentialsName)
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(todosListCredentialsValidator);
    }

    @ModelAttribute("todosLists")
    public List<TodosList> getTodosListsModelAttribute() {
        return todosListService.findAll();
    }

    @ModelAttribute(newTodosListCredentialsName)
    public TodosListCredentials getNewTodosListCredentialsModelAttribute(
            HttpSession httpSession) {
        TodosListCredentials credentials = (TodosListCredentials) httpSession.getAttribute(newTodosListCredentialsName);
        httpSession.removeAttribute(newTodosListCredentialsName);
        if (credentials == null) {
            return new TodosListCredentials();
        }
        return credentials;
    }

    @GetMapping({"", "/"})
    public String index() {
        return "IndexPage";
    }

    @PostMapping("/createTodosList")
    public String createTodosList(
            @Valid @ModelAttribute(newTodosListCredentialsName) TodosListCredentials newTodosListCredentials,
            BindingResult bindingResult,
            HttpSession httpSession) {
        if (bindingResult.hasErrors()) {
            httpSession.setAttribute(newTodosListCredentialsName, newTodosListCredentials);
            putErrorMessage(httpSession, bindingResult.getAllErrors().get(0).getDefaultMessage());
            return "redirect:/";
        }
        TodosList todosList = new TodosList(newTodosListCredentials.getTitle());
        todosListService.save(todosList);
        putMessage(httpSession, "You added a new todos list named " + todosList.getTitle());

        return "redirect:/";
    }

    @PostMapping("/deleteTodosList")
    public String deleteTodosList(@RequestParam Long id,
                                  HttpSession httpSession) {
        todosListService.deleteById(id);
        putMessage(httpSession, "You deleted todos list");
        return "redirect:/";
    }
}

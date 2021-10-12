package ru.ifmo.todosApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import ru.ifmo.todosApp.domain.Todo;
import ru.ifmo.todosApp.domain.TodosList;
import ru.ifmo.todosApp.form.TodoCredentials;
import ru.ifmo.todosApp.form.validator.TodoCredentialsValidator;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class TodosListPage extends Page {
    private final TodoCredentialsValidator todoCredentialsValidator;
    private Long lastNeededId;

    public TodosListPage(TodoCredentialsValidator todoCredentialsValidator) {
        this.todoCredentialsValidator = todoCredentialsValidator;
    }

    @ModelAttribute("todoCredentials")
    public TodoCredentials getTodoCredentials() {
        return new TodoCredentials();
    }

    @InitBinder("todoCredentials")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(todoCredentialsValidator);
    }

    @GetMapping("/todosList")
    public String getTodosListPage(@RequestParam Long id,
                                   Model model) {
        model.addAttribute("todosList", todosListService.findById(id));
        lastNeededId = id;
        return "TodosListPage";
    }

    @PostMapping("/createTodo")
    public String createTodo(@Valid @ModelAttribute TodoCredentials todoCredentials,
                             BindingResult bindingResult,
                             HttpSession httpSession) {
        if (bindingResult.hasErrors()) {
            putErrorMessage(httpSession, bindingResult.getAllErrors().get(0).getDefaultMessage());
            return "redirect:/todosList?id=" + lastNeededId;
        }
        TodosList currentList = todosListService.findById(lastNeededId);
        Todo todo = new Todo(todoCredentials.getTitle(), todoCredentials.getContent());
        currentList.getTodos().add(todo);
        todosListService.save(currentList);
        putMessage(httpSession, "You added a new todo: " + todo.getTitle());

        return "redirect:/todosList?id=" + lastNeededId;
    }
}

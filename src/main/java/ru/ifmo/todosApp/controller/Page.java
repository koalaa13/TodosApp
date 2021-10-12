package ru.ifmo.todosApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import ru.ifmo.todosApp.service.TodoService;
import ru.ifmo.todosApp.service.TodosListService;

import javax.servlet.http.HttpSession;

public class Page {
    private static final String MESSAGE_SESSION_KEY = "message";
    private static final String ERROR_MESSAGE_SESSION_KEY = "errorMessage";

    @Autowired
    protected TodosListService todosListService;

    @Autowired
    protected TodoService todoService;

    @ModelAttribute("message")
    public String getMessageModelAttribute(HttpSession httpSession) {
        String message = (String) httpSession.getAttribute(MESSAGE_SESSION_KEY);
        httpSession.removeAttribute(MESSAGE_SESSION_KEY);
        return message;
    }

    @ModelAttribute("errorMessage")
    public String getErrorMessageModelAttribute(HttpSession httpSession) {
        String message = (String) httpSession.getAttribute(ERROR_MESSAGE_SESSION_KEY);
        httpSession.removeAttribute(ERROR_MESSAGE_SESSION_KEY);
        return message;
    }

    protected void putErrorMessage(HttpSession httpSession, String errorMessage) {
        httpSession.setAttribute(ERROR_MESSAGE_SESSION_KEY, errorMessage);
    }

    protected void putMessage(HttpSession httpSession, String message) {
        httpSession.setAttribute(MESSAGE_SESSION_KEY, message);
    }
}

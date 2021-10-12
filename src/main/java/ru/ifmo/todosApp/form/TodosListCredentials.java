package ru.ifmo.todosApp.form;

import javax.validation.constraints.NotBlank;

public class TodosListCredentials {
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

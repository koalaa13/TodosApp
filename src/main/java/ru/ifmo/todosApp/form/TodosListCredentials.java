package ru.ifmo.todosApp.form;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TodosListCredentials {
    private String title;

    public TodosListCredentials(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

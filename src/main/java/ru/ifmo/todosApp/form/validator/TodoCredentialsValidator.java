package ru.ifmo.todosApp.form.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.ifmo.todosApp.form.TodoCredentials;

@Component
public class TodoCredentialsValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return TodoCredentials.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (!errors.hasErrors()) {
            TodoCredentials credentials = (TodoCredentials) target;
            if (credentials.getTitle() == null || credentials.getTitle().isEmpty()) {
                errors.rejectValue("title",
                        "todoTitle.invalid-title",
                        "Title for todo can not be empty");
            }
            if (credentials.getContent() == null || credentials.getContent().isEmpty()) {
                errors.rejectValue("content",
                        "todoContent.invalid-content",
                        "Content of todo can not be empty");
            }
        }
    }
}

package ru.ifmo.todosApp.form.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.ifmo.todosApp.form.TodosListCredentials;

@Component
public class TodosListCredentialsValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return TodosListCredentials.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (!errors.hasErrors()) {
            TodosListCredentials credentials = (TodosListCredentials) target;
            if (credentials.getTitle() == null || credentials.getTitle().isEmpty()) {
                errors.rejectValue("title",
                        "todosListTitle.invalid-title",
                        "Title for todos list can not be empty");
            }
        }
    }
}

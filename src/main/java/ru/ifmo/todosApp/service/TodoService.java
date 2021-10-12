package ru.ifmo.todosApp.service;

import org.springframework.stereotype.Service;
import ru.ifmo.todosApp.domain.Todo;
import ru.ifmo.todosApp.repository.TodoRepository;

import java.util.List;

@Service
public class TodoService {
    private final TodoRepository repository;

    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public Todo save(Todo todo) {
        return repository.save(todo);
    }

    public List<Todo> findAll() {
        return repository.findAll();
    }
}

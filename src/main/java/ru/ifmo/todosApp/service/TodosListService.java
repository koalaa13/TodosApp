package ru.ifmo.todosApp.service;

import org.springframework.stereotype.Service;
import ru.ifmo.todosApp.domain.TodosList;
import ru.ifmo.todosApp.repository.TodosListRepository;

import java.util.List;

@Service
public class TodosListService {
    private final TodosListRepository repository;

    public TodosListService(TodosListRepository repository) {
        this.repository = repository;
    }

    public TodosList save(TodosList todosList) {
        return repository.save(todosList);
    }

    public List<TodosList> findAll() {
        return repository.findAll();
    }
}

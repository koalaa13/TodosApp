package ru.ifmo.todosApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ifmo.todosApp.domain.TodosList;

@Repository
public interface TodosListRepository extends JpaRepository<TodosList, Long> {
}

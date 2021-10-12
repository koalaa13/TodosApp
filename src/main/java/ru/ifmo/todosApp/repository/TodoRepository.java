package ru.ifmo.todosApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ifmo.todosApp.domain.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
}

package ru.ifmo.todosApp.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(
        name = "todos_lists"
)
@Getter
@Setter
@RequiredArgsConstructor
public class TodosList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty
    @Size(min = 1, max = 150)
    private String title;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "todos_list_id")
    private List<Todo> todos;

    public TodosList(String title) {
        this.title = title;
        this.todos = new ArrayList<>();
    }
}

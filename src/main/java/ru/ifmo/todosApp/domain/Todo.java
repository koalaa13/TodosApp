package ru.ifmo.todosApp.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(
        name = "todos"
)
@Getter
@Setter
@RequiredArgsConstructor
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty
    @Size(min = 1, max = 150)
    private String title;

    @NotNull
    @NotEmpty
    @Lob
    @Size(min = 1, max = 4096)
    private String content;

    @CreationTimestamp
    private Date creationTime;
}

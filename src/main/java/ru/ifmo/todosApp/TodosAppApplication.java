package ru.ifmo.todosApp;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEncryptableProperties
public class TodosAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodosAppApplication.class, args);
	}

}

package org.example.expert.domain.todo.repository;

import org.example.expert.domain.todo.entity.Todo;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TodoCustomRepository {

    Optional<Todo> findByIdAndUser(Long todoId);

}

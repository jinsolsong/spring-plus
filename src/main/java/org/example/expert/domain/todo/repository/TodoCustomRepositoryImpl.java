package org.example.expert.domain.todo.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.example.expert.domain.todo.entity.Todo;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static org.example.expert.domain.todo.entity.QTodo.todo;
import static org.example.expert.domain.user.entity.QUser.user;


@Repository
@RequiredArgsConstructor
public class TodoCustomRepositoryImpl implements TodoCustomRepository{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Optional<Todo> findByIdAndUser(Long todoId) {
        Todo result = jpaQueryFactory
                .select(todo)
                .from(todo)
                .leftJoin(todo.user, user)
                .where(todo.id.eq(todoId))
                .fetchJoin()
                .fetchOne();

        return Optional.ofNullable(result);
    }
}

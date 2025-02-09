package com.todoback.todo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.todoback.todo.model.Todo;

public interface TodoRepo extends JpaRepository<Todo, Long> {
	List<Todo> findTodoByCategoryId(Long categoryId);
}

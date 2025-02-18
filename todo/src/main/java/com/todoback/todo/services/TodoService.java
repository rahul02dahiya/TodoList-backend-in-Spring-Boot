package com.todoback.todo.services;

import java.util.List;

import com.todoback.todo.model.Todo;


public interface TodoService {
	
	Todo save(Todo Todo);
	void delete(Long id);
	Todo findById(Long id);
	List<Todo> findByCategory(Long categoryId);
	List<Todo> findAllTodo();

}

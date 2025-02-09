package com.todoback.todo.services;

import java.util.List;

import com.todoback.todo.dto.TodoDto;

public interface TodoService {
	
	TodoDto save(TodoDto todoDto);
	void delete(Long id);
	TodoDto findById(Long id);
	List<TodoDto> findByCategory(Long categoryId);
	List<TodoDto> findAll();

}

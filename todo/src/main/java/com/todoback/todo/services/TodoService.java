package com.todoback.todo.services;

import java.util.List;

import com.todoback.todo.dto.TodoDto;

public interface TodoService {
	
	TodoDto save(TodoDto todoDto);
	void delete(int id);
	TodoDto findById(int id);
	List<TodoDto> findByCategory(int categoryId);
	List<TodoDto> findAll();

}

package com.todoback.todo.services;

import java.util.List;

import com.todoback.todo.dto.CategoryDto;

public interface CategoryService {
	
	CategoryDto save(CategoryDto category);
	void delete(int id);
	List<CategoryDto> findAllByUserId(int userId);
	CategoryDto findById(int id);
	List<CategoryDto> getAllTodoByCategoriesForToday(int userId);
	List<CategoryDto> findAll();
	
}

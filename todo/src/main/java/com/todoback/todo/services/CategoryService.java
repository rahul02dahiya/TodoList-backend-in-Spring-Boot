package com.todoback.todo.services;

import java.util.List;

import com.todoback.todo.dto.CategoryDto;

public interface CategoryService {
	
	CategoryDto save(CategoryDto category);
	void delete(Long id);
	List<CategoryDto> findAllByUserId(Long userId);
	CategoryDto findById(Long id);
	List<CategoryDto> getAllTodoByCategoriesForToday(Long userId);
	List<CategoryDto> findAll();
	
}

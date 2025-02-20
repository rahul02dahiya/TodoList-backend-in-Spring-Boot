package com.todoback.todo.services;

import java.util.List;

import com.todoback.todo.model.Category;

public interface CategoryService {
	
	Category save(Category category);
	void delete(Long id);
	List<Category> findAllByUserId(Long userId);
	Category findById(Long id);
	List<Category> findAllCategory();
	
}

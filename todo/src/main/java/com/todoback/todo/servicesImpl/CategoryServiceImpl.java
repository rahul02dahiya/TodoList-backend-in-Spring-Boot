package com.todoback.todo.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todoback.todo.dto.CategoryDto;
import com.todoback.todo.repositories.CategoryRepo;
import com.todoback.todo.services.CategoryService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepo categoryRepo;

	public CategoryServiceImpl(@Autowired CategoryRepo categoryRepo) {
		super();
		this.categoryRepo = categoryRepo;
	}

	@Override
	public CategoryDto save(CategoryDto category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<CategoryDto> findAllByUserId(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoryDto findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoryDto> getAllTodoByCategoriesForToday(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoryDto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}

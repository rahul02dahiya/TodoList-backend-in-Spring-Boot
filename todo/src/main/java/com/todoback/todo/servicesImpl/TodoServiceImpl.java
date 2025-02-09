package com.todoback.todo.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todoback.todo.dto.TodoDto;
import com.todoback.todo.repositories.TodoRepo;
import com.todoback.todo.services.TodoService;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class TodoServiceImpl implements TodoService {
	
	@Autowired
	private TodoRepo tedoRepo;

	public TodoServiceImpl(@Autowired TodoRepo tedoRepo) {
		super();
		this.tedoRepo = tedoRepo;
	}

	@Override
	public TodoDto save(TodoDto todoDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public TodoDto findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TodoDto> findByCategory(int categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TodoDto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}

package com.todoback.todo.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.todoback.todo.dto.UserDto;
import com.todoback.todo.repositories.UserRepo;
import com.todoback.todo.services.UserService;

public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo; 

	public UserServiceImpl(@Autowired UserRepo userRepo) {
		super();
		this.userRepo = userRepo;
	}

	@Override
	public UserDto save(UserDto user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<UserDto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto login(UserDto user) {
		// TODO Auto-generated method stub
		return null;
	}

}

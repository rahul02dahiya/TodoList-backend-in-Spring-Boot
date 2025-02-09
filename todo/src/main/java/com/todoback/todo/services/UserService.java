package com.todoback.todo.services;

import java.util.List;

import com.todoback.todo.dto.UserDto;

public interface UserService {
	
	UserDto save(UserDto user);
	void delete(int id);
	List<UserDto> findAll();
	UserDto findById(int id);
	UserDto login(UserDto user);
	
}

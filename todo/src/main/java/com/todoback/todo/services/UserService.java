package com.todoback.todo.services;

import java.util.List;

import com.todoback.todo.dto.UserDto;

public interface UserService {
	
	UserDto save(UserDto user);
	void delete(Long id);
	List<UserDto> findAll();
	UserDto findById(Long id);
	UserDto login(UserDto user);
	
}

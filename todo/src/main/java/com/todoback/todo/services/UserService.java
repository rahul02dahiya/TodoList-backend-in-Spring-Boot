package com.todoback.todo.services;

import java.util.List;

import com.todoback.todo.model.User;

public interface UserService {
	
	User save(User user);
	void delete(Long id);
	User findById(Long id);
	User login(User user);
	List<User> findAllUser();
}

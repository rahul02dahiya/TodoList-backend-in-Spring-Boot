package com.todoback.todo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todoback.todo.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	Optional<User> findUserByEmailAndPassword(String email, String password);
}

package com.todoback.todo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.todoback.todo.model.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

	private long id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	

}

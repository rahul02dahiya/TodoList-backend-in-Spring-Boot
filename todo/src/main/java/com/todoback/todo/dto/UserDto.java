package com.todoback.todo.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.todoback.todo.model.User;

public class UserDto {

	public UserDto(Long id, String firstName, String lastName, String email, String password,
			List<CategoryDto> category) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.category = category;
	}


	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	
	@JsonIgnore
	private List<CategoryDto> category;
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public List<CategoryDto> getCategory() {
		return category;
	}


	public void setCategory(List<CategoryDto> category) {
		this.category = category;
	}


	public static User toEntity(UserDto userDto) {
		
		User user = new User();
		
		user.setId(userDto.getId());
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setCategory(userDto.getCategory() != null ? userDto.getCategory().stream().map(CategoryDto::toEntity).collect(Collectors.toList()) : null) ;

		return user;
				
	}

	
	public static UserDto fromEntity(User user) {
	    UserDto userDto = new UserDto();
	    
	               userDto.setId(user.getId());
	               userDto.setFirstName(user.getFirstName());
	               userDto.setLastName(user.getLastName());
	               userDto.setEmail(user.getEmail());
	               userDto.setPassword(user.getPassword());
	               userDto.setCategory(user.getCategory() != null ? user.getCategory().stream().map(CategoryDto::fromEntity).collect(Collectors.toList()) : null);

	               return userDto;
	}


	@Override
	public String toString() {
		return "UserDto [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", category=" + category + "]";
	}

}

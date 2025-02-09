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
@Builder
public class UserDto {

	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	
	@JsonIgnore
	private List<CategoryDto> category;
	
	
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
	    return UserDto.builder()
	               .id(user.getId())
	               .firstName(user.getFirstName())
	               .lastName(user.getLastName())
	               .email(user.getEmail())
	               .password(user.getPassword())
	               .category(user.getCategory() != null ? user.getCategory().stream().map(CategoryDto::fromEntity).collect(Collectors.toList()) : null)
	               .build();
	}

}

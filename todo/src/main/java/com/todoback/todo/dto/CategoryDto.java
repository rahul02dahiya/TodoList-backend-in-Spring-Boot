package com.todoback.todo.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.todoback.todo.model.Category;
import com.todoback.todo.model.Todo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryDto {
	private int id;
	private String name;
	private String description;
	
	private UserDto user;
	private List<TodoDto> todoList;
	
	public static Category toEntity(CategoryDto categoryDto) {
		final Category category = new Category();
		category.setId(categoryDto.getId());
		category.setName(categoryDto.getName());
		category.setDescription(categoryDto.getDescription());
		category.setUser(UserDto.toEntity(categoryDto.getUser()));
		category.setTodoList(categoryDto.getTodoList() != null ? categoryDto.getTodoList().stream().map(TodoDto::toEntity).collect(Collectors.toList()) : null);
		
		return category;
	}
	
	public static CategoryDto fromEntity(Category category) {
		return CategoryDto.builder()
				.id(category.getId())
				.name(category.getName())
				.description(category.getDescription())
				.user(UserDto.fromEntity(category.getUser()))
				.todoList(category.getTodoList() != null ? category.getTodoList().stream().map(TodoDto::fromEntity).collect(Collectors.toList()) : null)
				.build();
	}
}

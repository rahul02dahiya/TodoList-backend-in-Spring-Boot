package com.todoback.todo.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.todoback.todo.model.Category;


public class CategoryDto {
	
	public CategoryDto(Long id, String name, String description, UserDto user, List<TodoDto> todoList) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.user = user;
		this.todoList = todoList;
	}

	public CategoryDto() {
		super();
	}

	private Long id;
	private String name;
	private String description;
	
	private UserDto user;
	private List<TodoDto> todoList;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

	public List<TodoDto> getTodoList() {
		return todoList;
	}

	public void setTodoList(List<TodoDto> todoList) {
		this.todoList = todoList;
	}

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
		final CategoryDto categoryDto = new CategoryDto();

				categoryDto.setId(category.getId());
				categoryDto.setName(category.getName());
				categoryDto.setDescription(category.getDescription());
				categoryDto.setUser(UserDto.fromEntity(category.getUser()));
				categoryDto.setTodoList(category.getTodoList() != null ? category.getTodoList().stream().map(TodoDto::fromEntity).collect(Collectors.toList()) : null);
				
				return categoryDto;
				
	}

	@Override
	public String toString() {
		return "CategoryDto [id=" + id + ", name=" + name + ", description=" + description + ", user=" + user
				+ ", todoList=" + todoList + "]";
	}
	
}

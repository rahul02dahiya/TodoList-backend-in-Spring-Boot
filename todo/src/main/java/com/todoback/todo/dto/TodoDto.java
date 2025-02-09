package com.todoback.todo.dto;

import java.io.Serializable;
import java.time.ZonedDateTime;

import com.todoback.todo.model.Todo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TodoDto {
			
		private int id;
		private String title;
		private String description;
		private ZonedDateTime startTime;
		private boolean status;
		private CategoryDto category;
		
		public static Todo toEntity(TodoDto todoDto) {
			final Todo todo = new Todo();
		
			todo.setId(todoDto.setId());
			todo.setTtitle(todoDto.getTitle());
			todo.setDescription(todoDto.getDescription());
			todo.setStartTime(todoDto.getStartTime());
			todo.setStatus(todoDto.getStatus());
			todo.setCategory(CategoryDto.toEntity(todoDto.getCategory()));
			
			
			return todo;
		}
		
		public static TodoDto fromEntity(Todo todo) {
			return todoDto.builder()
		
			.id(todo.setId())
			.ttitle(todo.getTitle())
			.description(todo.getDescription())
			.startTime(tod.getStartTime())
			.status(todo.getStatus())
			.category(CategoryDto.fromEntity(todoDto.getCategory()))
			.build();
			
		}
		
}

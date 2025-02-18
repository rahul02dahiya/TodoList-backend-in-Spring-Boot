package com.todoback.todo.dto;

import java.time.ZonedDateTime;

import com.todoback.todo.model.Todo;

public class TodoDto {

		private Long id;
		private String title;
		private String description;
		private ZonedDateTime startTime;
		private boolean status;
		private CategoryDto category;
		
		public TodoDto(Long id, String title, String description, ZonedDateTime startTime, boolean status,
				CategoryDto category) {
			super();
			this.id = id;
			this.title = title;
			this.description = description;
	        this.startTime = (startTime != null) ? startTime : ZonedDateTime.now();
			this.status = status;
			this.category = category;
		}

			public TodoDto() {
			super();
			this.startTime = ZonedDateTime.now();
		}
		
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public ZonedDateTime getStartTime() {
			return startTime;
		}

		public void setStartTime(ZonedDateTime startTime) {
			this.startTime = startTime;
		}

		public boolean getStatus() {
			return status;
		}

		public void setStatus(boolean status) {
			this.status = status;
		}

		public CategoryDto getCategory() {
			return category;
		}

		public void setCategory(CategoryDto category) {
			this.category = category;
		}

		public static Todo toEntity(TodoDto todoDto) {
			final Todo todo = new Todo();
		
			todo.setId(todoDto.getId());
			todo.setTitle(todoDto.getTitle());
			todo.setDescription(todoDto.getDescription());
	        todo.setStartTime(todoDto.getStartTime() != null ? todoDto.getStartTime() : ZonedDateTime.now());
			todo.setStatus(todoDto.getStatus());
			todo.setCategory(CategoryDto.toEntity(todoDto.getCategory()));
			
			return todo;
		}
		
		public static TodoDto fromEntity(Todo todo) {
			
			final TodoDto todoDto = new TodoDto();
			
			todoDto.setId(todo.getId());
			todoDto.setTitle(todo.getTitle());
			todoDto.setDescription(todo.getDescription());
			todoDto.setStartTime(todo.getStartTime());
			todoDto.setStatus(todo.getStatus());
			todoDto.setCategory(CategoryDto.fromEntity(todo.getCategory()));
			
			return todoDto;
		}

		@Override
		public String toString() {
			return "TodoDto [id=" + id + ", title=" + title + ", description=" + description + ", startTime="
					+ startTime + ", status=" + status + ", category=" + category + "]";
		}
		
}

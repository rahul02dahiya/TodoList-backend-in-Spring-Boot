package com.todoback.todo.servicesImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todoback.todo.dto.CategoryDto;
import com.todoback.todo.dto.TodoDto;
import com.todoback.todo.model.Category;
import com.todoback.todo.model.Todo;
import com.todoback.todo.repositories.CategoryRepo;
import com.todoback.todo.repositories.TodoRepo;
import com.todoback.todo.services.TodoService;
import com.todoback.todo.validators.TodoValidator;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class TodoServiceImpl implements TodoService {
	
	@Autowired
	private TodoRepo todoRepo;

	@Autowired
	private CategoryRepo categoryRepo;
	
	

	public TodoServiceImpl(@Autowired TodoRepo tedoRepo, @Autowired CategoryRepo categoryRepo) {
		super();
		this.todoRepo = tedoRepo;
		this.categoryRepo = categoryRepo;
	}

	@Override
	public TodoDto save(TodoDto todoDto) {
		// TODO Auto-generated method stub
		List<String> errors = TodoValidator.validateTodo(todoDto);
		if(!errors.isEmpty()) {
			log.error("Todo is not valid {}",todoDto);
			return null;
		}
		return TodoDto.fromEntity(todoRepo.save(TodoDto.toEntity(todoDto)));
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		if(id == null) {
			log.error("Todo id is null");
			return;
		}
		todoRepo.deleteById(id);
	}

	@Override
	public TodoDto findById(Long id) {
		// TODO Auto-generated method stub
		if (id==null) {
			log.error("User id cannot be null");
			return null;
		}

		 final Long categoryId = categoryRepo.findCategoryByTodoId(id);
	        Category category = new Category();
	        category.setId(categoryId);

	        final Optional<Todo> todo = todoRepo.findById(id);
	        if (!todo.isPresent()) {
	            log.error("No Todo found with ID = {}", id);
	            return null;
	        }

	        todo.get().setCategory(category);
	        TodoDto todoDto = TodoDto.fromEntity(todo.get());
	        todoDto.setCategory(CategoryDto.fromEntity(category));

	        return todoDto;
	}

	@Override
	public List<TodoDto> findByCategory(Long categoryId) {
		// TODO Auto-generated method stub
		return todoRepo.findTodoByCategoryId(categoryId).stream()
                .map(TodoDto::fromEntity)
                .collect(Collectors.toList());
	}

	@Override
	public List<TodoDto> findAll() {
		// TODO Auto-generated method stub
		return todoRepo.findAll().stream()
				.map(TodoDto::fromEntity)
				.collect(Collectors.toList());
	}


}

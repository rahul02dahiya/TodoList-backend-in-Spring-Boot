package com.todoback.todo.servicesImpl;
import java.util.logging.Logger;

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


@Service
public class TodoServiceImpl implements TodoService {
	
    private static final Logger log = Logger.getLogger(TodoServiceImpl.class.getName());
	
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
			log.info("Todo is not valid");
			return null;
		}
		return TodoDto.fromEntity(todoRepo.save(TodoDto.toEntity(todoDto)));
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		if(id == null) {
			log.info("Todo id is null");
			return;
		}
		todoRepo.deleteById(id);
	}

	@Override
	public TodoDto findById(Long id) {
		// TODO Auto-generated method stub
		if (id==null) {
			log.info("User id cannot be null");
			return null;
		}

		 final Long categoryId = categoryRepo.findCategoryByTodoId(id);
	        Category category = new Category();
	        category.setId(categoryId);

	        final Optional<Todo> todo = todoRepo.findById(id);
	        if (!todo.isPresent()) {
	            log.info("No Todo found with ID ");
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

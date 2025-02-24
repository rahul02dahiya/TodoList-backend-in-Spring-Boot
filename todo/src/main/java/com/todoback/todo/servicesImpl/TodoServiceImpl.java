package com.todoback.todo.servicesImpl;
import java.util.logging.Logger;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public Todo save(Todo todo) {
		// TODO Auto-generated method stub
		List<String> errors = TodoValidator.validateTodo(todo);
		if(!errors.isEmpty()) {
			log.info("Todo is not valid");
			return null;
		}
		return todoRepo.save(todo);
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
	public Todo findById(Long id) {
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
	        Todo Todo = todo.get();
	        Todo.setCategory(category);

	        return Todo;
	}

	@Override
	public List<Todo> findByCategory(Long categoryId) {
		// TODO Auto-generated method stub
		return todoRepo.findTodoByCategoryId(categoryId);
	}

	@Override
	public List<Todo> findAllTodo() {
		// TODO Auto-generated method stub
		return todoRepo.findAll();
	}

	@Override
	public Todo update(Todo todo, Long id) {
		// TODO Auto-generated method stub
		List<String> errors = TodoValidator.validateTodo(todo);
		if(!errors.isEmpty()) {
			log.info("Todo is not valid");
			return null;
		}
		todo.setId(id);
		return todoRepo.save(todo);
	}

	@Override
	public void updateStatus(Boolean status, Long id) {
		 Optional<Todo> existingTodo = todoRepo.findById(id);
	        if (existingTodo.isPresent()) {
	            Todo todo = existingTodo.get();
	            todo.setStatus(status);
	            todoRepo.save(todo);
	        }
	}


}

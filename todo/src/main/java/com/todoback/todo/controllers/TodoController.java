package com.todoback.todo.controllers;

import com.todoback.todo.dto.TodoDto;
import com.todoback.todo.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;
    

    public TodoController( @Autowired TodoService todoService) {
		super();
		this.todoService = todoService;
	}

	@PostMapping("/save")
    public TodoDto saveTodo(@RequestBody TodoDto todoDto) {
        return todoService.save(todoDto);
    }

    @GetMapping("/all")
    public List<TodoDto> getAllTodos() {
        return todoService.findAll();
    }

    @GetMapping("/{id}")
    public TodoDto getTodoById(@PathVariable Long id) {
        return todoService.findById(id);
    }

    @GetMapping("/category/{categoryId}")
    public List<TodoDto> getTodosByCategory(@PathVariable Long categoryId) {
        return todoService.findByCategory(categoryId);
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id) {
        todoService.delete(id);
    }
}

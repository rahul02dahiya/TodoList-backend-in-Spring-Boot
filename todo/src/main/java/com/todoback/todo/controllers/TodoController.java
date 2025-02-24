package com.todoback.todo.controllers;

import com.todoback.todo.model.Todo;
import com.todoback.todo.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
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
    public Todo saveTodo(@RequestBody Todo todo) {
        return todoService.save(todo);
    }
	
	 @PutMapping("/update/{id}")
	    public Todo updateTodo(@RequestBody Todo todo, @PathVariable Long id) {
	        return todoService.update(todo, id);
	    }
	 
	 @PutMapping("/status/{id}")
	    public ResponseEntity<String> updateStatus(@PathVariable Long id, @RequestParam boolean status) {
	        todoService.updateStatus(status, id);
	        return ResponseEntity.ok("Updated todo status successfully.");
	    }

    @GetMapping("/all")
    public List<Todo> getAllTodos() {
        return todoService.findAllTodo();
    }

    @GetMapping("/{id}")
    public Todo getTodoById(@PathVariable Long id) {
        return todoService.findById(id);
    }

    @GetMapping("/category/{categoryId}")
    public List<Todo> getTodosByCategory(@PathVariable Long categoryId) {
        return todoService.findByCategory(categoryId);
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id) {
        todoService.delete(id);
    }
}

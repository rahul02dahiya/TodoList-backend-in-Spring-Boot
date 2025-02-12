package com.todoback.todo.controllers;

import com.todoback.todo.dto.CategoryDto;
import com.todoback.todo.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    
    public CategoryController( @Autowired CategoryService categoryService) {
		super();
		this.categoryService = categoryService;
	}

	@PostMapping("/save")
    public CategoryDto saveCategory(@RequestBody CategoryDto categoryDto) {
        return categoryService.save(categoryDto);
    }

    @GetMapping("/all")
    public List<CategoryDto> getAllCategories() {
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public CategoryDto getCategoryById(@PathVariable Long id) {
        return categoryService.findById(id);
    }

    @GetMapping("/user/{userId}")
    public List<CategoryDto> getCategoriesByUser(@PathVariable Long userId) {
        return categoryService.findAllByUserId(userId);
    }

    @GetMapping("/today/{userId}")
    public List<CategoryDto> getAllTodoByCategoriesForToday(@PathVariable Long userId) {
        return categoryService.getAllTodoByCategoriesForToday(userId);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.delete(id);
    }
}

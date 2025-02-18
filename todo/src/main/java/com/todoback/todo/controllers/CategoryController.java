package com.todoback.todo.controllers;

import com.todoback.todo.model.Category;
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
    public Category saveCategory(@RequestBody Category category) {
        return categoryService.save(category);
    }

    @GetMapping("/all")
    public List<Category> getAllCategories() {
        return categoryService.findAllCategory();
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id) {
        return categoryService.findById(id);
    }

    @GetMapping("/user/{userId}")
    public List<Category> getCategoriesByUser(@PathVariable Long userId) {
        return categoryService.findAllByUserId(userId);
    }

    @GetMapping("/today/{userId}")
    public List<Category> getAllTodoByCategoriesForToday(@PathVariable Long userId) {
        return categoryService.getAllTodoByCategoriesForToday(userId);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.delete(id);
    }
}

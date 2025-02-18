package com.todoback.todo.validators;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.todoback.todo.model.Todo;

public class TodoValidator {
	
	public static List<String> validateTodo(Todo todo) {
        List<String> errors = new ArrayList<>();
        if (todo == null) {
            errors.add("Please fill the title");
            errors.add("Please fill the description");
            errors.add("Please select a category");
            return errors;
        }
        if (StringUtils.isEmpty(todo.getTitle())) {
            errors.add("Please fill the title");
        }
        if (StringUtils.isEmpty(todo.getDescription())) {
            errors.add("Please fill the description");
        }
        if (StringUtils.isEmpty(todo.getCategory())) {
            errors.add("Please select a category");
        }
        return errors;
    }
}
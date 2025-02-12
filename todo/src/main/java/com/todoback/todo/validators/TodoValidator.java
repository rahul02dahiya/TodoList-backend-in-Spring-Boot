package com.todoback.todo.validators;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.todoback.todo.dto.TodoDto;

public class TodoValidator {
	
	@SuppressWarnings("deprecation")
	public static List<String> validateTodo(TodoDto todoDto) {
        List<String> errors = new ArrayList<>();
        if (todoDto == null) {
            errors.add("Please fill the title");
            errors.add("Please fill the description");
            errors.add("Please select a category");
            return errors;
        }
        if (StringUtils.isEmpty(todoDto.getTitle())) {
            errors.add("Please fill the title");
        }
        if (StringUtils.isEmpty(todoDto.getDescription())) {
            errors.add("Please fill the description");
        }
        if (StringUtils.isEmpty(todoDto.getCategory())) {
            errors.add("Please select a category");
        }
        return errors;
    }
}
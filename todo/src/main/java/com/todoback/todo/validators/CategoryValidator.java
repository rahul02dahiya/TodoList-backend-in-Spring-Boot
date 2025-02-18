package com.todoback.todo.validators;

import java.util.ArrayList;
import java.util.List;

import com.todoback.todo.model.Category;

import io.micrometer.common.util.StringUtils;

public class CategoryValidator {

	public static List<String> validateCategory(Category category){
		List<String> errors = new ArrayList<>();
		
		if(category == null) {
			errors.add("Please fill the name");
			errors.add("Please fill the description");
			return errors;
		}
		
		if(StringUtils.isEmpty(category.getName())) {
			errors.add("Please fill the name");
		}
		
		if(StringUtils.isEmpty(category.getDescription())) {
			errors.add("Please fill the description");
		}
		
		return errors;
	}
}

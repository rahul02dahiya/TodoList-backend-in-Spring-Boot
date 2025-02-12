package com.todoback.todo.validators;

import java.util.ArrayList;
import java.util.List;
import org.springframework.util.StringUtils;
import com.todoback.todo.dto.UserDto;

public class UserValidator {
	
	public static List<String> validateUser(UserDto userDto) {
		
        List<String> errors = new ArrayList<>();
        
        if (userDto == null) {
            errors.add("Please fill the First name");
            errors.add("Please fill the Last name");
            errors.add("Please fill the user Email");
            errors.add("Please fill the User Password");
            return errors;
        }

        if (StringUtils.isEmpty(userDto.getFirstName())) {
            errors.add("Please fill the First name");
        }
        if (StringUtils.isEmpty(userDto.getLastName())) {
            errors.add("Please fill the Last name");
        }
       
        if (StringUtils.isEmpty(userDto.getEmail())) {
            errors.add("Please fill the user Email");
        }
        if (StringUtils.isEmpty(userDto.getPassword())) {
            errors.add("Please fill the User Password");
        }

        return errors;
    }

	public static List<String> validateUserCredentials(String email, String password) {
        List<String> errors = new ArrayList<>();
        if (StringUtils.isEmpty(email)) {
            errors.add("Email is empty");
        }
        if (StringUtils.isEmpty(password)) {
            errors.add("Password is empty");
        }
        return errors;
    }
}

package com.todoback.todo.controllers;

import com.todoback.todo.dto.UserDto;
import com.todoback.todo.model.User;
import com.todoback.todo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    public UserController( @Autowired UserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping("/save")
    public UserDto saveUser(@RequestBody UserDto userDto) {
        return userService.save(userDto);
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUser();
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping("/login")
    public UserDto loginUser(@RequestBody UserDto user) {
        return userService.login(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.delete(id);
    }
}

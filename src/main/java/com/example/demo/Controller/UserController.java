package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.example.demo.Service.UserService;
import com.example.demo.dto.UserDto;

@RestController
public class UserController<User> {
	@Autowired
	UserService userService;

	@PostMapping("/addUser")
	public ResponseEntity<String> addUser(@RequestBody final UserDto userDto) {
		final boolean status = userService.addUser(userDto);
		if (status) {
			return ResponseEntity.ok().body("user added successfully");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null);
		}
	}

	@GetMapping("/users")
	public List<com.example.demo.doamin.User> getAllUsers() {
		return userService.getUsers();
	}

}

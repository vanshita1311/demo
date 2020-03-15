package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Service.UserService;
import com.example.demo.dto.UserDto;

@RestController
public class UserController {
	@Autowired
	UserService userService;
	
@PostMapping("/addUser")	
public ResponseEntity<String>addUser(@RequestBody UserDto userDto)
{
	boolean status=userService.addUser(userDto);
	if(status)
	{
	return ResponseEntity.ok().body("user added successfully");
	}
	else
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null);

}

}

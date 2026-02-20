package com.milanmiljkovic.controller;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.milanmiljkovic.exception.EmailExistsException;
import com.milanmiljkovic.exception.UsernameExistsException;
import com.milanmiljkovic.model.User;
import com.milanmiljkovic.service.UserService;

@RestController
public class UserController {
		
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String greeting() {
		return "Hello World";
	}

	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody User userToRegister) throws EmailExistsException, UsernameExistsException {
			this.userService.register(userToRegister);		
			return ResponseEntity.status(HttpStatus.SC_CREATED).build();
	}
	
	@GetMapping("/login")
	public String login(@RequestBody User userToLogin) {
		
		return "Successfully logged in";
	}

}

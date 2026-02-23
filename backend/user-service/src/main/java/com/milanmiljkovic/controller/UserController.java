package com.milanmiljkovic.controller;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.milanmiljkovic.dto.AuthRequest;
import com.milanmiljkovic.dto.AuthResponse;
import com.milanmiljkovic.exception.EmailExistsException;
import com.milanmiljkovic.exception.UsernameExistsException;
import com.milanmiljkovic.service.UserService;

@RestController
public class UserController {
		
	@Autowired
	private UserService userService;
	
	@GetMapping("/hello")
	public String greeting() {
		return "Hello World";
	}

	@PostMapping("/register")
	public ResponseEntity<Void> register(@RequestBody AuthRequest authRequest) throws EmailExistsException, UsernameExistsException {
			this.userService.register(authRequest);		
			return ResponseEntity.status(HttpStatus.SC_CREATED).build();
	}
	
	@PostMapping("/login")
	public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest userToLogin) {
		return ResponseEntity.ok(new AuthResponse(this.userService.login(userToLogin)));
	}

}

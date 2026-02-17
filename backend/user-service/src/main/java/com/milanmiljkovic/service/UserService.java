package com.milanmiljkovic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.milanmiljkovic.exception.EmailExistsException;
import com.milanmiljkovic.exception.UsernameExistsException;
import com.milanmiljkovic.model.User;
import com.milanmiljkovic.repo.UserRepo;

@Service
public class UserService {

	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	
	public void register(User userToRegister) throws EmailExistsException, UsernameExistsException {
		
		if (userRepo.findByEmail(userToRegister.getEmail()).isPresent()) {
			throw new EmailExistsException("email already exists in the database");
		}
		
		if (userRepo.findByUsername(userToRegister.getUsername()).isPresent()) {
			throw new UsernameExistsException("username already exists");
		}
				
		User user = new User();
		user.setEmail(userToRegister.getEmail());
		user.setUsername(userToRegister.getUsername());
		user.setPassword(encoder.encode(userToRegister.getPassword()));
		
		userRepo.save(user);		
	}
}

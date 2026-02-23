package com.milanmiljkovic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.milanmiljkovic.dto.AuthRequest;
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
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JWTService jwtService;
	
	@Autowired
	private CustomUserDetailsService detailsService;
	
	public void register(AuthRequest userToRegister) throws EmailExistsException, UsernameExistsException {
		
		if (userRepo.findByEmail(userToRegister.email()).isPresent()) {
			throw new EmailExistsException("email already exists in the database");
		}
		
		if (userRepo.findByUsername(userToRegister.username()).isPresent()) {
			throw new UsernameExistsException("username already exists");
		}
				
		User user = new User();
		user.setEmail(userToRegister.email());
		user.setUsername(userToRegister.username());
		user.setPassword(encoder.encode(userToRegister.password()));
		
		userRepo.save(user);		
	}
	
	public String login(AuthRequest userToLogin) {
		
		this.authenticationManager
			.authenticate(new UsernamePasswordAuthenticationToken(userToLogin.email(), userToLogin.password()));
		
		UserDetails userDetails = detailsService.loadUserByUsername(userToLogin.email());
		String token = this.jwtService.generateToken(userToLogin.email());
		
		return token;
	}
}

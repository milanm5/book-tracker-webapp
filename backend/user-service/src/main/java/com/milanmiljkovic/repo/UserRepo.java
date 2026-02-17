package com.milanmiljkovic.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.milanmiljkovic.model.User;

public interface UserRepo extends JpaRepository<User, Integer>{

	Optional<User> findByEmail(String email);
	
	Optional<User> findByUsername(String username);
}

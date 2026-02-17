package com.milanmiljkovic.exception;

import org.apache.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(EmailExistsException.class)
	public ResponseEntity<String> handleEmailExists(EmailExistsException ex) {
		return ResponseEntity.status(HttpStatus.SC_CONFLICT).body(ex.getMessage());
	}
}

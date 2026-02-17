package com.milanmiljkovic.exception;

public class UsernameExistsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2135231255807892615L;
	
	public UsernameExistsException(String errorMessage, Throwable err) {
		super(errorMessage, err);
	}

	public UsernameExistsException(String errorMessage) {
		super(errorMessage);
	}
	
	
}

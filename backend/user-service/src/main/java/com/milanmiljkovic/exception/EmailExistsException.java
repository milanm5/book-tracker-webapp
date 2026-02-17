package com.milanmiljkovic.exception;

public class EmailExistsException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5795436337364311394L;

	public EmailExistsException(String errorMessage, Throwable err) {
		super(errorMessage, err);
	}

	public EmailExistsException(String errorMessage) {
		super(errorMessage);
	}
}

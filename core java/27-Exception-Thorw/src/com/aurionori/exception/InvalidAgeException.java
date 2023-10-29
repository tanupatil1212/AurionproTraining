package com.aurionori.exception;

public class InvalidAgeException extends RuntimeException{
	
	
	String message;

	public InvalidAgeException(String message) {
		super(message);
		this.message=message;
		
	}
	
	@Override
	public String getMessage() {
		return this.getClass().getName()+": "+message;
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName()+": "+message;
	}

	
	

}

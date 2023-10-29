package com.aurionpro.exception;
import com.aurionpro.model.Account;


public class TransationFailed extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	String message;

	public TransationFailed(String message) {
		super(message);
		this.message = message;
	}
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return this.message.getClass().getName()+" : "+message;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.message.getClass().getName()+" : ";
	}
	
	
	

}

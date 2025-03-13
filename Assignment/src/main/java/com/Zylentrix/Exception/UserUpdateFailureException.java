package com.Zylentrix.Exception;

public class UserUpdateFailureException extends RuntimeException {
	private String message;
	
	public String getMessage() {
		return message;
	}

	public UserUpdateFailureException(String message) {
		super();
		this.message = message;
	}
	
	

}

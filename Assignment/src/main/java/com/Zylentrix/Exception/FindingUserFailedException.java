package com.Zylentrix.Exception;

public class FindingUserFailedException extends RuntimeException {
	private String message;
	
	public String getMessage() {
		return message;
	}

	public FindingUserFailedException(String message) {
		super();
		this.message = message;
	}
}

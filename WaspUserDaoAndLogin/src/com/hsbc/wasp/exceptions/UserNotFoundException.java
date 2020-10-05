package com.hsbc.wasp.exceptions;

public class UserNotFoundException extends Exception{
	private int userId;

	public UserNotFoundException(int userId) {
		super();
		this.userId = userId;
	}
	public void showMessage() {
		System.out.println("User with ID: " + userId +" not found.");
	}

}


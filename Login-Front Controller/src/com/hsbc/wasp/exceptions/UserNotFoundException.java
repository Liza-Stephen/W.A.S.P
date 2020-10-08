package com.hsbc.wasp.exceptions;

public class UserNotFoundException extends Exception{
	private int userId;

	public UserNotFoundException(int userId) {
		super();
		this.userId = userId;	//For log purpose
	}
	public String showMessage() {
		return "User not found";
	}

}


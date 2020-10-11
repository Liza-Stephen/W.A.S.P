package com.bugstrack.exceptions;

public class UserNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7793928695563261742L;
	public String message() {
		return "UserNotFoundException";
	}
	

}

package com.bugstrack.exceptions;

public class UserNotLoggedInException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4527354013452464755L;
	
	
	
	public String message() {
		return "UserNotLoggedInException";
	}
	

}

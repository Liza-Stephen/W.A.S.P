package com.bugstrack.exceptions;

public class UserAlreadyLoggedInException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1373330893613466759L;

	public String message() {
		return "UserAlreadyLoggedInException";
	}

}

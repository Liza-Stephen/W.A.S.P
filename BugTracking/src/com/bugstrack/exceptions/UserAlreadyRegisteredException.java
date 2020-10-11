package com.bugstrack.exceptions;

public class UserAlreadyRegisteredException extends Exception{

	private static final long serialVersionUID = 1038704686460183979L;

	/**
	 * 
	 */
	public String message() {
		return "UserAlreadyRegisteredException";
	}

}

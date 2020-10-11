package com.bugstrack.exceptions;

public class BugAlreadyExistsException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 299172316463181225L;

	public String message() {
		return "BugAlreadyExistsException";
	}

}

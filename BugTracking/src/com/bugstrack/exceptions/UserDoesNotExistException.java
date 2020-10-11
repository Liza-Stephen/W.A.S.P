package com.bugstrack.exceptions;

public class UserDoesNotExistException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 473494414045392013L;
	public String message() {
		return "UserDoesNotExistException";
	}

}

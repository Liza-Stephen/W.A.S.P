package com.bugstrack.exceptions;

public class RoleDoesNotExistException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5845320650038060602L;
	public String message() {
		return "RoleDoesNotExistException";
	}
}

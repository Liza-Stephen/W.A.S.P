package com.bugstrack.exceptions;


public class UserCannotLoginException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = -999973675756340710L;

	public String message() {
		return "UserCannotLoginException";
	}
}

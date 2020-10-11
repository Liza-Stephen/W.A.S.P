package com.bugstrack.exceptions;

public class BugAlreadyClosedException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4774594327802011552L;
	
	public String message() {
		return "BugAlreadyClosedException";
	}

}

package com.bugstrack.exceptions;

public class EmptyBugsListException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4987363981404880070L;
	public String message() {
		return "EmptyBugsListException";
	}

}

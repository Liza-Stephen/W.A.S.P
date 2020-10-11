package com.bugstrack.exceptions;

public class BugsNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3269964889756140541L;
	
	public String message() {
		return "BugsNotFoundException";
	}

}

package com.bugstrack.exceptions;

public class AlreadyMarkedForClosing extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4152121846988940534L;
	public String message() {
		return "AlreadyMarkedForClosing";
	}

}

package com.hsbc.wasp.exceptions;

public class BugNotAssignedException extends Exception{
	
	public BugNotAssignedException() {
		super();
	}
	public String showMessage() {
		return "Cannot assign bug!";
	}

}
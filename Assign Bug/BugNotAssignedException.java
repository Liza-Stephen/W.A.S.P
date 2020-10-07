package com.hsbc.wasp.exceptions;

public class BugNotAssignedException extends Exception{
	
	public BugNotAssignedException() {
		super();
	}
	public void showMessage() {
		System.out.println("Cannot assign bug!");
	}

}
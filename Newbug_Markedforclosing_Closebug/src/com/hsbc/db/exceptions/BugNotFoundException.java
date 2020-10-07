package com.hsbc.db.exceptions;

public class BugNotFoundException extends Exception{
	

	public BugNotFoundException() {
		super();
		
	}
	public String showMessage() {
		return "Bug Not Found!";
	}
	
	

}

package com.hsbc.db.exceptions;

public class ProjectNotFoundException extends Exception {

	

	public ProjectNotFoundException() {
		super();
	}
	public String showMessage() {
		return "Project Not Found!";
	}
	
	
}

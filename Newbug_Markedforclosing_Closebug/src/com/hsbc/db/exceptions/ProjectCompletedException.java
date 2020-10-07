package com.hsbc.db.exceptions;

public class ProjectCompletedException extends Exception{

	public ProjectCompletedException() {
		super();
		
	}
	public String showMessage() {
		return "Project Status is Completed !";
	}


}

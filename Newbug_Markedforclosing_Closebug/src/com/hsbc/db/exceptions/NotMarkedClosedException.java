package com.hsbc.db.exceptions;

public class NotMarkedClosedException extends Exception {

	public NotMarkedClosedException() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String showMessage() {
		return "Bug Not Marked for Closing!";
	}

}

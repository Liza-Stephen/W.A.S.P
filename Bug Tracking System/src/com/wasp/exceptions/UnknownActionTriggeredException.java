package com.wasp.exceptions;

public class UnknownActionTriggeredException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2703058180432752487L;
	
	String userid;
	String log;
	//Time at which it was triggered
	public UnknownActionTriggeredException(String userid, String log) {
		super();
		this.userid = userid;
		this.log = log;
	}
	
	public void logException() {
		//Log Exception using this function to the database.
	}
	

}

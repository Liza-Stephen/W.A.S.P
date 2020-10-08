package com.hsbc.wasp.exceptions;

public class UserCannotLoginException extends Exception{
	String msg;
	public UserCannotLoginException(String msg) {
		super();
		this.msg = msg;		
	}
	public String showMessage() {
		return msg;
	}
}

package com.wasp.exceptions;

public class UserCannotLoginException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = -999973675756340710L;
	String msg;
	public UserCannotLoginException(String msg) {
		super();
		this.msg = msg;		
	}
	public String showMessage() {
		return msg;
	}
}

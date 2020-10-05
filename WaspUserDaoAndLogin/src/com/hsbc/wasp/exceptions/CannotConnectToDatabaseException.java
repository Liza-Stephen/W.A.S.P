package com.hsbc.wasp.exceptions;

public class CannotConnectToDatabaseException extends Exception{
	private int userId;

	public CannotConnectToDatabaseException() {
		super();
	}
	public void showMessage() {
		System.out.println("Cannot connect to databse!");
	}

}

package com.bugstrack.exceptions;

import java.sql.SQLException;

public class CustomSQLException extends SQLException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5091250783353515135L;
	public String message() {
		return "CustomSQLException";
	}
	

}

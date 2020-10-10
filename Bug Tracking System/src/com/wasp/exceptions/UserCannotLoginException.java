package com.wasp.exceptions;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.wasp.database.DatabaseConnect;

public class UserCannotLoginException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = -999973675756340710L;


	private int userid;
	private Timestamp timestamp;
	//Time at which it was triggered
	public UserCannotLoginException(int userid, Timestamp timestamp) {
		super();
		this.userid = userid;
		this.timestamp = timestamp;
	}
	
	public void log() {
		Connection connection = DatabaseConnect.connect();
		try {
			ResultSet rs = connection.createStatement().executeQuery("insert into logs(logName,description,causedByUser,) values('UserCannotLoginException','UserCannotLoginException',"+userid+","+timestamp+");");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}

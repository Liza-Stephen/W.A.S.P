package com.wasp.exceptions;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.wasp.database.DatabaseConnect;

public class FieldNotMatchingWithExistingDB extends Exception{

	/**
	 * 
	 */
	private int userid;
	private Timestamp timestamp;
	private static final long serialVersionUID = 8610146431089254104L;
	public FieldNotMatchingWithExistingDB(int userid,Timestamp timestamp) {
		this.timestamp = timestamp;
		this.userid = userid;
	}
	
	
	public void log() {
		Connection connection = DatabaseConnect.connect();
		try {
			ResultSet rs = connection.createStatement().executeQuery("insert into logs(logName,description,causedByUser,) values('FieldNotMatchingWithExistingDB','FieldNotMatchingWithExistingDB',"+userid+","+timestamp+");");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}

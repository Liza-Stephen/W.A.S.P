package com.wasp.exceptions;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;

import com.bugstrack.db.DatabaseConnection;

public class UserNotLoggedInException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4527354013452464755L;
	
	private int userId;
	
	public UserNotLoggedInException(int userId) {
		this.userId = userId;
	}
	
	
	void log() throws SQLException {
		Connection con = DatabaseConnection.getConnection();
		Statement st = con.createStatement();
		Timestamp timestamp = new Timestamp(new Date().getTime());
		ResultSet rs = st.executeQuery("insert into logs(logName,description,causedByUser,logtime) values('UserNotLoggedInException','UserNotLoggedInException',"+userId+","+timestamp+");");
		
	}
	

}

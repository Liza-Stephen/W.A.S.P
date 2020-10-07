package com.hsbc.db.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtility {
	
	static Connection con;
	static {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			con = DriverManager.getConnection("jdbc:derby:F:/derbydb/bugtrack");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection() {
		return con;
	}
}

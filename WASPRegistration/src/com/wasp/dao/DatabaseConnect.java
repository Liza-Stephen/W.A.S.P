package com.wasp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnect {
	
	private static Connection con;
	
	static {
		try {
			con = DriverManager.getConnection("jdbc:derby:d:/Database/wasp");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection connect() {
		return con;
	}

}

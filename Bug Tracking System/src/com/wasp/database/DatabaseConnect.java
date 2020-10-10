package com.wasp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnect {
	
	public static Connection con;

	static {
		try {
			//Add relative path here
			con = DriverManager.getConnection("jdbc:derby:D:\\W.A.S.P\\Database\\bugtrack");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Connection connect() {
		return con;
	}

	@Override
	protected void finalize() throws Throwable {
		con.close();
	}

}

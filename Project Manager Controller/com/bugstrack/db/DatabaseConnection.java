package com.bugstrack.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private static Connection conn;
	static
	{
		try
		{
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			conn=DriverManager.getConnection("jdbc:derby:f:/derbydb/bugtrack");
		}
		catch(SQLException sql)
		{
		}
		catch(ClassNotFoundException ex)
		{
			
		}
	}
	private DatabaseConnection()
	{
		
	}
	public static Connection getConnection()
	{
	
		
		return conn;
	}
	public static void close()  {
		// TODO Auto-generated method stub
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   conn=null;
	}
	
}

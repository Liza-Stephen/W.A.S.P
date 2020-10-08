package com.hsbc.wasp.dao;

import com.hsbc.wasp.exceptions.UserCannotLoginException;
import com.hsbc.wasp.exceptions.UserNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hsbc.wasp.db.DBUtility;
import com.hsbc.wasp.entity.User;
import com.hsbc.wasp.entity.UserLogin;

public class UserDao {
	Connection con;
	String query;
	Statement stmt;
	PreparedStatement pst;
	ResultSet rs;
	
	public User getUser(int userId) throws UserNotFoundException {
		con = DBUtility.getConnection();
		String userName;
		String role;
		try {
			query = "select * from users where userId=" + userId;
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			if(rs.next()) {
				userName = rs.getString(2);
				role = rs.getString(3);
			}
			else {
				return null;
			}
			
			User u =new User(userId, userName, role);
			return u;
		}
		catch(SQLException ex) {
			throw new UserNotFoundException(userId);
		}
	}
}

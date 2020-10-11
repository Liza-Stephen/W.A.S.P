package com.hsbc.wasp.dao;

import com.hsbc.wasp.exceptions.UserCannotLoginException;
import com.hsbc.wasp.exceptions.UserNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import com.hsbc.wasp.db.DBUtility;
import com.hsbc.wasp.entity.User;

public class UserDao {
	Connection con;
	String query;
	Statement stmt;
	PreparedStatement pst;
	ResultSet rs;
	
	public User getUser(String emailId) throws UserCannotLoginException {
		con = DBUtility.getConnection();
		
		try {
			query = "select * from users where emailId=" + emailId;
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			if(rs.next()) {
				int userId = rs.getInt(1);
				String userName = rs.getString(2);
				String password = rs.getString(4);
				Timestamp lastLogin = rs.getTimestamp(5);
				boolean isRegistered = rs.getBoolean(6);
				User u =new User(userId, userName, emailId, password, lastLogin, isRegistered);
				return u;
			}
			else {
				return null;
			}
		}
		catch(SQLException ex) {
			throw new UserCannotLoginException(ex.toString());
		}
	}
	public int updateLastLogin(User u) throws UserCannotLoginException {
		con = DBUtility.getConnection();
		try {
			query = "update user set lastLogin=? where userId=?";
			pst = con.prepareStatement(query);
			pst.setTimestamp(1,u.getLastLogin());
			pst.setInt(2,u.getUserId());
			int num = pst.executeUpdate();
			return num;
		}
		catch(SQLException ex) {
			throw new UserCannotLoginException(ex.toString());
		}
	}
}

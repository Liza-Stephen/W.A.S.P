package com.wasp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import com.wasp.database.DatabaseConnect;
import com.wasp.entity.User;
import com.wasp.exceptions.UserCannotLoginException;
import com.wasp.interfaces.LoginInterface;


public class LoginDAO implements LoginInterface{
	Connection con;
	String query;
	Statement stmt;
	PreparedStatement pst;
	ResultSet rs;
	User u;
	
	@Override
	public User getUser(String emailId) throws UserCannotLoginException {
		con = DatabaseConnect.connect();
		
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
				u =new User(userId, userName, emailId, password, lastLogin, isRegistered);
				
			}
			else {
				throw new UserCannotLoginException(u.getUserId(), u.getLastLogin());
			}
		}
		catch(SQLException ex) {
			ex.printStackTrace();		}
		return u;
	}
	
	@Override
	public int updateLastLogin(User u) {
		con = DatabaseConnect.connect();
		try {
			query = "update users set lastLogin=? where userId=?";
			pst = con.prepareStatement(query);
			pst.setTimestamp(1,u.getLastLogin());
			pst.setInt(2,u.getUserId());
			int num = pst.executeUpdate();
			return num;
		}
		catch(SQLException ex) {
			ex.printStackTrace();	
		}
		//if the function returns -1 then update last login failed
		return -1;
	}
}

package com.hsbc.wasp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import com.hsbc.wasp.db.DBUtility;
import com.hsbc.wasp.entity.UserLogin;
import com.hsbc.wasp.exceptions.UserCannotLoginException;

public class UserLoginDao {
	Connection con;
	String query;
	Statement stmt;
	PreparedStatement pst;
	ResultSet rs;
	
	public UserLogin getUserLogin(String emailId) throws UserCannotLoginException {
		con = DBUtility.getConnection();
		int userId = 0;
		String password = null;
		Timestamp lastLogin = null;
		try {
			query = "select * from userLogin where emailId=?";
			pst = con.prepareStatement(query);
			pst.setString(1, emailId);
			rs = pst.executeQuery();
			if(rs.next()) {
				userId = rs.getInt(1);
				password = rs.getString(3);
				lastLogin = rs.getTimestamp(4);
				UserLogin u = new UserLogin(userId, emailId, password, lastLogin);
				return u;
			}
			else 
				return null;			
		}
		catch(SQLException ex) {
			throw new UserCannotLoginException(ex.toString());
		}
	}
	
	public int updateLastLogin(UserLogin u) throws UserCannotLoginException {
		con = DBUtility.getConnection();
		try {
			query = "update userLogin set lastLogin=? where email=?";
			pst = con.prepareStatement(query);
			pst.setTimestamp(1,u.getLastLogin());
			pst.setString(2,u.getEmailId());
			int num = pst.executeUpdate();
			return num;
		}
		catch(SQLException ex) {
			throw new UserCannotLoginException(ex.toString());
		}
	}

}

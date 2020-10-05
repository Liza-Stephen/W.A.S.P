package com.hsbc.wasp.dao;

import com.hsbc.wasp.exceptions.UserNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hsbc.wasp.db.DBUtility;
import com.hsbc.wasp.entity.User;

public class UserDao {
	Connection con;
	String query;
	Statement stmt;
	PreparedStatement pst;
	ResultSet rs;
	
	public User getUser(int userId) {
		con = DBUtility.getConnection();
		String userName;
		String emailId;
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
			query = "select * from userLogin where userId=" + userId;
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			if(rs.next()) {
				emailId = rs.getString(1);
			}
			else {
				return null;
			}
			User u =new User(userId, userName, emailId, role);
			return u;
		}
		catch(SQLException ex) {
			return null;
		}
	}
//	public void deleteUser(int userId) throws UserNotFoundException {
//		con = DBUtility.getConnection();
//		try {
//			query = "delete from users where userId=?";
//			pst = con.prepareStatement(query);
//			pst.setInt(1, userId);
//			int count1 = pst.executeUpdate();
//			if(count1==0)
//				throw new UserNotFoundException(userId);
//			query = "delete from userLogin where userId=?";
//			pst = con.prepareStatement(query);
//			pst.setInt(1, userId);
//			pst.executeUpdate();			
//		}
//		catch(SQLException ex) {
//			ex.printStackTrace();
//		}
//	}
}

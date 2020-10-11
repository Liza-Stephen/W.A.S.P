package com.wasp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import com.wasp.database.DatabaseConnect;
import com.wasp.entity.Roles;
import com.wasp.entity.User;
import com.wasp.exceptions.FieldNotMatchingWithExistingDB;
import com.wasp.exceptions.UserAlreadyRegisteredException;
import com.wasp.exceptions.UserCannotLoginException;
import com.wasp.interfaces.UserInterface;


public class UserDAO implements UserInterface{
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
			query = "select * from users where emailId='" + emailId+"'";
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
			query = "update users set lastLoggedIn=? where userId=?";
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
	
	@Override
	public void registerUser(User user,Roles role) throws UserAlreadyRegisteredException, FieldNotMatchingWithExistingDB, SQLException {
		
		Connection connection = DatabaseConnect.connect();
		//connection.setAutoCommit(false);
		//Task 2 done, Task 3.
		Statement st1 = connection.createStatement();
		Statement st2 = connection.createStatement();
		ResultSet resultquery = st1.executeQuery("select * from roles inner join users on roles.userid = users.userid where users.userid = "+user.getUserId());
		
		//Declaring variables below
		String roleUser;
		int userId;
		String email;
		Timestamp timestamp;
		boolean isRegistered;
		
		//Task 4
		
			while(resultquery.next()) {
					roleUser = resultquery.getString("role");
					userId = resultquery.getInt("userId");
					email = resultquery.getString("emailId"); //created field is emailId and not email in the table.
					timestamp = resultquery.getTimestamp("lastLoggedIn");
					isRegistered = resultquery.getBoolean("isRegistered");
					System.out.println(roleUser+" "+email+" "+timestamp);
					if(isRegistered) {
						throw new UserAlreadyRegisteredException(userId, timestamp);
					}
					if(user.getEmailId().equalsIgnoreCase(email) && role.getRole().equalsIgnoreCase(roleUser) ) {

						st2.executeUpdate("update users set password ='"+user.getPassword() +"' where userid="+user.getUserId());
					}
					else {
						throw new FieldNotMatchingWithExistingDB(userId, user.getLastLogin());
					}
				
			}
			
			//statement1.close();
		
		
		connection.close();
		//Task 5 to be done by the servlet
		
		
		
	}
	
	
}

package com.bugstrack.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bugstrack.db.DatabaseConnection;
import com.bugstrack.domain.User;
import com.bugstrack.exceptions.UserAlreadyRegisteredException;
import com.bugstrack.exceptions.UserDoesNotExistException;
import com.bugstrack.exceptions.UserNotFoundException;
import com.bugstrack.interfaces.UserInterface;

public class UserDAO implements UserInterface {
    private Connection userDao;
    public UserDAO(){
    	userDao=DatabaseConnection.getConnection();
    }
	@Override
	public void addUser(User user) throws UserDoesNotExistException {
		String query="insert into users(userName,emailId) values(?,?)";
	     try {
			PreparedStatement ps=userDao.prepareStatement(query);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getEmailId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public User getUser(int userId) throws UserDoesNotExistException {
		String query ="select * from users where userId=?";
		PreparedStatement ps;
		User user=null;
		try {
			ps = userDao.prepareStatement(query);
			ps.setInt(1, userId);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				user=new User(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// close();
		return user;
	}
	@Override
	public List<Integer> getAllUser() {
		String query ="select userId from users";
		List<Integer> list=null;
		Statement stmt;
		try {
			stmt = userDao.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			list=new ArrayList<Integer>();
			while(rs.next())
			{
				list.add(rs.getInt(1));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// close();
		return list;
	}
	@Override
	public int lastrowAdded() {
		String query="select max(userId) from users";
    	Statement stmt;
    	int res=0;
		try {
			stmt = userDao.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next())
			{
				res=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// close();
    	return res;
	}
	@Override
	public void updatePassword(String emailId, String password) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updateLastLogin(String emailId) {
		String query="update users set lastLogin=? where emailId=?";
    	try {
			PreparedStatement ps=userDao.prepareStatement(query);
			Date date=new Date();
			Timestamp timestamp=new Timestamp(date.getTime());
			ps.setTimestamp(1, timestamp);
			ps.setString(2, emailId);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); // throw exception
		}
		
	}
	@Override
	public void registerUser(String emailId, String password) throws UserAlreadyRegisteredException, UserNotFoundException, UserDoesNotExistException {
		int userId=getUserIdByemail(emailId);
    	User user=getUser(userId);
    	if(user.isRegistered())
    		System.out.println("Allready "); // throw exception
    	
    	String query="update users set password=?,isRegistered=? where userId=?";
    	try {
			PreparedStatement ps=userDao.prepareStatement(query);
			ps.setString(1, password);
			ps.setBoolean(2, true);
			ps.setInt(3, userId);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); // throw exception
		}
		
	}
	@Override
	public int getUserIdByemail(String emailId) throws UserNotFoundException {
		int res=0;
    	String query="select userId from users where emailId=?";
    	try {
			PreparedStatement ps=userDao.prepareStatement(query);
			ps.setString(1, emailId);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				res=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return res;
	}
	@Override
	public void close() {
		userDao=null;
		DatabaseConnection.close();
		
	}

}
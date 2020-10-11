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
import com.bugstrack.interfaces.UserInterface;

public class UserDAO implements UserInterface {
    private Connection userDao;
    public UserDAO()
    {
    	userDao=DatabaseConnection.getConnection();
    }
	public void addUser(User user) {
		// TODO Auto-generated method stub
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
    // close();
	}
    public void registerUser(String emailId,String password)
    {
    	int userId=getUserIdByemail(emailId);
    	User user=getUser(userId);
    	if(!user.isRegistered())
    		System.out.println("Allready "); // throw exception
    	Date date=new Date();
    	Timestamp st=new Timestamp(date.getTime());
    	String query="update users set password=?,lastLoggedin=?,isRegistered=? where userId=?";
    	try {
			PreparedStatement ps=userDao.prepareStatement(query);
			ps.setString(1, password);
			ps.setTimestamp(2, st);
			ps.setBoolean(3, true);
			ps.setInt(4, userId);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); // throw exception
		}
    	// close();
    }
	public User getUser(int userId) {
		// TODO Auto-generated method stub
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

	public List<Integer> getAllUser() {
		// TODO Auto-generated method stub
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
    public int lastrowAdded()
    {
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
    
    public void updatePassword(String emailId,String password)
    {
    	
    }
    public void updateLastLogin(String emailId)
    {
    	
    }
    public int getUserIdByemail(String emailId)
    {
    	return 0;
    }
	public void close()
	{
		userDao=null;
		DatabaseConnection.close();
	}
}

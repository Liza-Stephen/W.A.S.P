package com.bugstrack.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bugstrack.db.DatabaseConnection;
import com.bugstrack.exceptions.RoleDoesNotExistException;
import com.bugstrack.interfaces.RolesInterface;

public class RolesDAO implements RolesInterface {
    private Connection rolesDao;
    
	public RolesDAO() {
		super();
	    rolesDao=DatabaseConnection.getConnection();
	}

	public void addRoles(int userId, String role) throws RoleDoesNotExistException{
		// TODO Auto-generated method stub
       String query="insert into roles(userId,role) values(?,?)";
       try {
		PreparedStatement ps=rolesDao.prepareStatement(query);
		ps.setInt(1, userId);
		ps.setString(2, role);
		ps.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }

	public String getRole(int userId) {
		// TODO Auto-generated method stub
	   String roles=null;
		String query="select role from roles where userId=?";
		try {
			PreparedStatement ps=rolesDao.prepareStatement(query);
			ps.setInt(1, userId);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				roles=rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return roles;
	}
	
	
	
    public List<Integer> getUserByRole(String role) throws RoleDoesNotExistException{
    	List<Integer> users=null;
		String query="select userId from roles where role=?";
		try {
			PreparedStatement ps=rolesDao.prepareStatement(query);
			ps.setString(1, role);
			ResultSet rs=ps.executeQuery();
			users=new ArrayList<Integer>();
			while(rs.next())
			{
				users.add(rs.getInt(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
    }
}

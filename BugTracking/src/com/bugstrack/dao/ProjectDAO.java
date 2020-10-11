package com.bugstrack.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.derby.iapi.store.raw.PageTimeStamp;

import com.bugstrack.db.DatabaseConnection;
import com.bugstrack.domain.Project;
import com.bugstrack.exceptions.ProjectAlreadyAddedException;
import com.bugstrack.exceptions.ProjectDoesNotExistExeption;
import com.bugstrack.exceptions.UserDoesNotExistException;
import com.bugstrack.interfaces.ProjectInterface;

public class ProjectDAO implements ProjectInterface {
    	
	private Connection projectDao;
	public ProjectDAO() {
		projectDao=DatabaseConnection.getConnection();
	}

	public void addProject(Project p) throws ProjectAlreadyAddedException{
		// TODO Auto-generated method stub
        String query ="insert into project(pname,description,startDate,status,manager) values(?,?,?,?,?)";
        java.util.Date temp=p.getStartDate();
        java.sql.Date sqlDate=new java.sql.Date(temp.getTime());
        PreparedStatement ps;
		try {
			ps = projectDao.prepareStatement(query);
		    ps.setString(1, p.getpName());
	        ps.setString(2, p.getDescription());
	        ps.setDate(3, sqlDate);
	        ps.setString(4, p.getStatus());
	        ps.setInt(5, p.getManager());
	        ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
    public String getStatus(int pid)
    {
    	String status=null;
		String query="select status from project where pid=?";
		PreparedStatement ps;
		try {
			ps=projectDao.prepareStatement(query);
			ps.setInt(1, pid);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				status=rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// close();
		return status;
    }
	public Project getProject(int pid) throws ProjectDoesNotExistExeption{
		// TODO Auto-generated method stub
		Project p=null;
		String query="select * from project where pid=?";
		PreparedStatement ps;
		try {
			ps=projectDao.prepareStatement(query);
			ps.setInt(1, pid);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				
				p=new Project(pid, rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5),rs.getInt(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// close();
		return p;
	}

	public List<Project> getAllProject() {
		// TODO Auto-generated method stub
		String query="select * from project";
		List<Project> list=null;
		try {
			PreparedStatement ps=projectDao.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			list=new ArrayList<Project>();
			while(rs.next())
			{
				int pId=rs.getInt(1);
				String pName=rs.getString(2);
				String description=rs.getString(3);
				java.sql.Date date=rs.getDate(4);
				java.util.Date startDate=new java.util.Date(date.getTime());
				String status=rs.getString(5);
				int manager=rs.getInt(6);
				list.add(new Project(pId, pName, description, startDate, status,manager));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	 close();
		return list;
	}
	public List<Integer> getAllProjectByManager(int manager) {
		// TODO Auto-generated method stub
		String query="select pid from project where manager=?";
		List<Integer> list=null;
		try {
			PreparedStatement ps=projectDao.prepareStatement(query);
			ps.setInt(1, manager);
			ResultSet rs=ps.executeQuery();
			list=new ArrayList<Integer>();
			while(rs.next())
			{
				int pid=rs.getInt(1);
				list.add(pid);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	 close();
		return list;
	}

	public void updateStatus(int pid, String status) {
		// TODO Auto-generated method stub
        String query="update project set status=? where pid=?";
        try {
			PreparedStatement ps=projectDao.prepareStatement(query);
			ps.setInt(2, pid);
			ps.setString(1, status);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     //   close();
        }
	public int lastrowAdded()
    {
    	String query="select max(pid) from project";
    	Statement stmt;
    	int res=0;
		try {
			stmt = projectDao.createStatement();
			ResultSet rs=stmt.executeQuery(query);
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
	public int getManager(int pid) throws UserDoesNotExistException
	{
		int manager=0;
		String query="select manager from project where pid=?";
		PreparedStatement ps;
		try {
			ps=projectDao.prepareStatement(query);
			ps.setInt(1, pid);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				manager=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// close();
		return manager;
	}
	public void close()
	{
		projectDao=null;
		DatabaseConnection.close();
	}
}

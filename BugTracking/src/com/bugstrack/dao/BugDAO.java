package com.bugstrack.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bugstrack.db.DatabaseConnection;
import com.bugstrack.domain.Bug;
import com.bugstrack.exceptions.AlreadyMarkedForClosing;
import com.bugstrack.exceptions.BugAlreadyClosedException;
import com.bugstrack.exceptions.BugAlreadyExistsException;
import com.bugstrack.exceptions.EmptyBugsListException;
import com.bugstrack.interfaces.BugInterface;

public class BugDAO implements BugInterface {
    private Connection bugDao;
    
	public BugDAO() {
		super();
		bugDao=DatabaseConnection.getConnection();
	}
	
	@Override
	public boolean getIsMarkedforClosing(int bugId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void add(Bug bug) throws BugAlreadyExistsException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void markforclosing(int bugId) throws AlreadyMarkedForClosing {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void closeBug(int bugId) throws BugAlreadyClosedException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void close() {
		bugDao=null;
		DatabaseConnection.close();
		
	}


	@Override
	public List<Bug> getBugs(int pId) throws EmptyBugsListException {
		String query="select * from bugs where pid=?";
		List<Bug> list=null;
		try {
			PreparedStatement ps=bugDao.prepareStatement(query);
			ps.setInt(1, pId);
			ResultSet rs=ps.executeQuery();
			list=new ArrayList<Bug>();
			while(rs.next())
			{
				int bugId=rs.getInt(1);
				String title=rs.getString(2);
				String description=rs.getString(3);
				int testerId=rs.getInt(5);
				Date openDate=rs.getDate(6);
				int assignedto=rs.getInt(7);
				boolean isMarkedforClosing=rs.getBoolean(8);
				int closedBy=rs.getInt(9);
				Date closedOn=rs.getDate(10);
				String status=rs.getString(11); 
				String severityLevel=rs.getString(12);
				list.add(new Bug(bugId, title, description, pId, testerId, openDate, assignedto, isMarkedforClosing, closedBy, closedOn, status, severityLevel));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}


	@Override
	public int lastrowAdded() {
		String query="select max(bugId) from bugs";
    	Statement stmt;
    	int res=0;
		try {
			stmt = bugDao.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next())
			{
				res=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// close();
    	return res;
	}

	
}

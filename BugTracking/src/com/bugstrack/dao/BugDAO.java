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
import com.bugstrack.exceptions.BugsNotFoundException;
import com.bugstrack.exceptions.CustomSQLException;
import com.bugstrack.exceptions.EmptyBugsListException;
import com.bugstrack.interfaces.BugInterface;

public class BugDAO implements BugInterface {
    private Connection con;
    
	public BugDAO() {
		super();
		con=DatabaseConnection.getConnection();
	}
	
	@Override
	public boolean getIsMarkedforClosing(int bugId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void add(String projectName ,Bug bug) throws BugAlreadyExistsException, CustomSQLException {
		try {
			PreparedStatement pst1 = con.prepareStatement("select * from project where pname=?");
			pst1.setString(1, projectName);
			ResultSet rs = pst1.executeQuery();
			
			if (rs.next()) {
				int id = rs.getInt(1);
				String status = rs.getString(5);
				String str = "In-progress";					
				if(status.equals(str)) {
					PreparedStatement pst = con.prepareStatement("insert into  bugs(title,description,severitylevel,pid,opendate,testerid) values(?,?,?,?,?,?);");
					pst.setString(1, bug.getTitle());
					pst.setString(2, bug.getDescription());
					pst.setString(3, bug.getSeverityLevel());
					pst.setInt(4,id);
					Date opendate=Date.valueOf(bug.getOpenDate());
					pst.setDate(5,opendate );
					pst.setInt(6,bug.getTesterId());
					pst.executeUpdate();		
				}
			}
		}catch(SQLException e) {
			throw new CustomSQLException();
		}

		
	}


	@Override
	public void markforclosing(int bugId) throws AlreadyMarkedForClosing, BugsNotFoundException, CustomSQLException {
		try {
			PreparedStatement pst = con.prepareStatement("select * from bugs where bugid=?");
			pst.setInt(1, bugId);
			ResultSet rs = pst.executeQuery();			
			if (rs.next()) {
				String query = "update bugs set ismarkedforclosing=? where bugid=?";
				PreparedStatement pst1 = con.prepareStatement(query);
				pst1.setBoolean(1, true);
				pst1.setInt(2, bugId);
				pst.executeUpdate();
			}
			else
				throw new BugsNotFoundException();		
		}
		catch (SQLException e1) {
			throw new CustomSQLException();
		}	
		
	}


	@Override
	public void closeBug(Bug bug) throws BugAlreadyClosedException, CustomSQLException {
		try {
			String query = "select ismarkedforclosing from bugs where bugid=?";
			String query1= "update bugs set closedon=?,closedby=? where bugid=?";
			
			PreparedStatement pst1=con.prepareStatement(query);
			pst1.setInt(1,bug.getBugId());
			ResultSet rs = pst1.executeQuery();
			if (rs.next()) {
				boolean condition = rs.getBoolean(8);
				if(condition) {
					PreparedStatement pst=con.prepareStatement(query1);
					Date closedon=Date.valueOf(bug.getClosedOn());
					pst.setDate(1,closedon );
					pst.setInt(2,bug.getClosedBy());
					pst.setInt(3,bug.getBugId());
					pst.executeUpdate();
				}
				else
					throw new BugAlreadyClosedException();
			}
		}
		catch (SQLException e1) {
			throw new CustomSQLException();
		}
		
	}


	@Override
	public void close() {
		con=null;
		DatabaseConnection.close();
		
	}


	@Override
	public List<Bug> getBugs(int pId) throws EmptyBugsListException {
		String query="select * from bugs where pid=?";
		List<Bug> list=null;
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, pId);
			ResultSet rs=ps.executeQuery();
			list=new ArrayList<Bug>();
			while(rs.next())
			{
				int bugId=rs.getInt(1);
				String title=rs.getString(2);
				String description=rs.getString(3);
				int testerId=rs.getInt(5);
				String openDate=rs.getDate(6).toString();
				int assignedto=rs.getInt(7);
				boolean isMarkedforClosing=rs.getBoolean(8);
				int closedBy=rs.getInt(9);
				String closedOn=rs.getDate(10).toString();
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
			stmt = con.createStatement();
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

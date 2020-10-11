package com.hsbc.db.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.hsbc.db.exceptions.BugNotFoundException;
import com.hsbc.db.exceptions.NotMarkedClosedException;
import com.hsbc.db.exceptions.ProjectCompletedException;
import com.hsbc.db.exceptions.ProjectNotFoundException;





public class BugDao implements Dao {
	Connection con ;
	Statement stmt;
	String  st;
	public BugDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void add (String name,String title,String desc,String date,String severity,int testerid) throws ProjectNotFoundException, ProjectCompletedException {
		
		
			
			try {
				
	
				con = DBUtility.getConnection();
				
				PreparedStatement pst1 = con.prepareStatement("select * from project where pname=?");
				pst1.setString(1, name);
				PreparedStatement pst = con.prepareStatement("insert into  bugs(title,description,severitylevel,pid,opendate,testerid) values(?,?,?,?,?,?);");
				ResultSet rs = pst1.executeQuery();
				
				if (rs.next()) {
					int id = rs.getInt(1);
					String status=rs.getString(5);
					String str1="In-progress";
					
						
					if(status.equals(str1)) {
						pst.setString(1, title);
						pst.setString(2, desc);
						pst.setString(3, severity);
						pst.setInt(4,id);
						Date opendate=Date.valueOf(date);
						pst.setDate(5,opendate );
						pst.setInt(6,testerid);
						pst.executeUpdate();
					}
					else
						throw new ProjectCompletedException();
					
					
					
				}
				else
					throw new ProjectNotFoundException();
				
				
			} catch (SQLException e1) {
				
				e1.printStackTrace();
				
			}
		


	}

	@Override
	public void MarkForClosing(int id) throws BugNotFoundException {
		try {
		st = "select * from bugs where bugid=" + id;
		String st1="update bugs set ismarkedforclosing='true' where bugid="+id;
		con = DBUtility.getConnection();
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(st);
		if (rs.next()) {
			stmt.executeUpdate(st1);
		}
		else
			throw new BugNotFoundException();
		
		}catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	}

	@Override
	public void CloseBug(int id,String date,int closedby) throws NotMarkedClosedException {
		try {
			st = "select ismarkedforclosing from bugs where bugid=?";
			String st1="update bugs set closedon =?,closedby =? where bugid=?";
			con = DBUtility.getConnection();
			PreparedStatement pst1=con.prepareStatement(st);
			pst1.setInt(1,id);
			PreparedStatement pst=con.prepareStatement(st1);
			ResultSet rs = pst1.executeQuery();
			if (rs.next()) {
				Date closedon=Date.valueOf(date);
				pst.setDate(1,closedon );
				pst.setInt(2,closedby);
				pst.setInt(3,id);
				pst.executeUpdate();
			}
			else
				throw new NotMarkedClosedException();
			
			}catch (SQLException e1) {
				e1.printStackTrace();
			}
		
		
	}
	
	
}
		
		
	
	


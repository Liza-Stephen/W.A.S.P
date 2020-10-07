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
				
				 
				st = "select pid from project where pName=" + name;
				String st1 = "select status from project where pName=" + name;
				con = DBUtility.getConnection();
				
				stmt = con.createStatement();
				PreparedStatement pst = con.prepareStatement("insert into  bugs(title,description,severitylevel,pid,opendate,testerid) values(?,?,?,?,?,?);");
				ResultSet rs = stmt.executeQuery(st);
				
				if (rs.next()) {
					int id = rs.getInt(1);
					ResultSet rs1 = stmt.executeQuery(st1);
					if(rs1.next()) {
						String status=rs1.getString(1);
						String str1="In-progress";
						if(status.equals(str1)) {
							pst.setString(2, title);
							pst.setString(3, desc);
							pst.setInt(4,id);
							pst.setInt(5,testerid);
							Date opendate=Date.valueOf(date);
							pst.setDate(6,opendate );
							pst.setString(12, severity);

							pst.executeUpdate();
						}
						else
							throw new ProjectCompletedException();
					}
					
					
				}
				else
					throw new ProjectNotFoundException();
				
				
			} catch (SQLException e1) {
				
				e1.printStackTrace();
				
			}
		


	}

	@Override
	public void MarkForClosing(String name) throws BugNotFoundException {
		try {
		st = "select bugid from bugs where title=" + name;
		String st1="update bugs set ismarkedforclosing='true' where title="+name;
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
	public void CloseBug(String name,String date,int closedby) throws NotMarkedClosedException {
		try {
			st = "select ismarkedforclosing from bugs where title=" + name;
			String st1="update bugs set closedon =?,closedby =? where title="+name;
			con = DBUtility.getConnection();
			stmt = con.createStatement();
			PreparedStatement pst=con.prepareStatement(st1);
			ResultSet rs = stmt.executeQuery(st);
			if (rs.next()) {
				pst.setInt(9,closedby);
				Date closedon=Date.valueOf(date);
				pst.setDate(10,closedon );
				

				pst.executeUpdate();
			}
			else
				throw new NotMarkedClosedException();
			
			}catch (SQLException e1) {
				e1.printStackTrace();
			}
		
		
	}
	
	
}
		
		
	
	


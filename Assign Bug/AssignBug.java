package com.hsbc.wasp.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hsbc.wasp.db.DBUtility;
import com.hsbc.wasp.exceptions.BugNotAssignedException;

public class AssignBug {
	
	
	public static int assignBug(int pid, int developerId) throws BugNotAssignedException {
		Connection con = DBUtility.getConnection();
		String query = "update bugs set assignedto=? where pid=?";
		try {
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, developerId);
			pst.setInt(2, pid);
			int num = pst.executeUpdate();
			if(num==1)
				return 1;		//Success
			if(num!=1) 
				throw new BugNotAssignedException();
		} catch (SQLException e) {
			throw new BugNotAssignedException();
		}
		return 0;		//Failure
	}
}

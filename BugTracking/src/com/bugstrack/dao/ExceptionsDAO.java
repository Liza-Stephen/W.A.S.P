package com.bugstrack.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.bugstrack.db.DatabaseConnection;
import com.bugstrack.domain.Exceptions;
import com.bugstrack.interfaces.ExceptionInterface;

public class ExceptionsDAO implements ExceptionInterface{

	List<Exceptions> exceptionList;
	private Connection con;
	
	public ExceptionsDAO() {
		super();
		con=DatabaseConnection.getConnection();
	}
	
	@Override
	public void logException(String logname,int userId,Timestamp timestamp) {
		try {
			PreparedStatement ps = con.prepareStatement("insert into logs(logname,causedbyuser,logtime) values(?,?,?)");
			ps.setString(1,logname );
			ps.setInt(2,userId );
			ps.setTimestamp(3, timestamp);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Exceptions> getAllException() {
		exceptionList = new ArrayList<Exceptions>();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from logs");
			while(rs.next()) {
				int logId = rs.getInt("logid");
				String logname = rs.getString("logname");
				int userId = rs.getInt("causedbyuser");
				Timestamp timestamp = rs.getTimestamp("logtime");
				exceptionList.add(new Exceptions(logId, logname, userId, timestamp));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return exceptionList;
	}

	@Override
	public List<Exceptions> getExceptionsByUser(int userId) {
		exceptionList = new ArrayList<Exceptions>();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from logs where userid = "+userId);
			while(rs.next()) {
				int logId = rs.getInt("logid");
				String logname = rs.getString("logname");
				int uid = rs.getInt("causedbyuser");
				Timestamp timestamp = rs.getTimestamp("logtime");
				exceptionList.add(new Exceptions(logId, logname, uid, timestamp));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return exceptionList;
	}

}

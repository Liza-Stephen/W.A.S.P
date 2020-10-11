package com.bugstrack.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bugstrack.db.DatabaseConnection;
import com.bugstrack.exceptions.CustomSQLException;
import com.bugstrack.exceptions.UserAlreadyLoggedInException;
import com.bugstrack.exceptions.UserNotLoggedInException;
import com.bugstrack.interfaces.UserLoggedInInterface;

public class UserLoggedInDAO implements UserLoggedInInterface{
	private Connection con;
	
	public UserLoggedInDAO() {
		con = DatabaseConnection.getConnection();
	}

	@Override
	public boolean isCurrentlyLoggedIn(int userId) throws CustomSQLException {
		ResultSet rs;
		try {
			rs = con.createStatement().executeQuery("select userid from usercurrentlogged where userid = "+userId);
			if(rs.first()) {
				return false;
			}
				else {
					return true;
				}
		} catch (SQLException e) {
			throw new CustomSQLException();
		}
	}

	@Override
	public void logOut(int userId) throws UserNotLoggedInException, CustomSQLException {
		PreparedStatement pst;
		try {
			pst = con.prepareStatement("delete from usercurrentlogged where userid = ?");
			pst.setInt(1, userId);
			pst.executeUpdate();
			pst.close();
		} catch (SQLException e) {
			throw new CustomSQLException();
		}
		
	}

	@Override
	public void logIn(int userId) throws UserAlreadyLoggedInException {
		PreparedStatement pst;
		try {
			pst = con.prepareStatement("insert into usercurrentlogged values(?)");
			pst.setInt(1, userId);
			pst.executeUpdate();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}

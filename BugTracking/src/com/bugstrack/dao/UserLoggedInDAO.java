package com.bugstrack.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bugstrack.db.DatabaseConnection;
import com.bugstrack.interfaces.UserLoggedInInterface;
import com.wasp.exceptions.UserAlreadyLoggedInException;
import com.wasp.exceptions.UserNotLoggedInException;

public class UserLoggedInDAO implements UserLoggedInInterface{
	private Connection con;
	
	public UserLoggedInDAO() {
		con = DatabaseConnection.getConnection();
	}

	@Override
	public boolean isCurrentlyLoggedIn(int userId) {
		Statement st;
		try {
			ResultSet rs = con.createStatement().executeQuery("select userid from usercurrentlogged where userid = "+userId);
			if(rs.first()) {
				return false;
			}
				else {
					return true;
				}
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void logOut(int userId) throws UserNotLoggedInException {
		PreparedStatement pst;
		try {
			pst = con.prepareStatement("delete from usercurrentlogged where userid = ?");
			pst.setInt(1, userId);
			pst.executeUpdate();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
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

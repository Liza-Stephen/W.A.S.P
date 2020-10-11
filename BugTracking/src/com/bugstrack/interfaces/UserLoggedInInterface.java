package com.bugstrack.interfaces;

import java.sql.SQLException;

import com.wasp.exceptions.UserAlreadyLoggedInException;
import com.wasp.exceptions.UserNotLoggedInException;

public interface UserLoggedInInterface {
	
	public boolean isCurrentlyLoggedIn(int userId) throws SQLException;
	
	public void logOut(int userId) throws UserNotLoggedInException;
	
	public void logIn(int userId) throws UserAlreadyLoggedInException;
	
}

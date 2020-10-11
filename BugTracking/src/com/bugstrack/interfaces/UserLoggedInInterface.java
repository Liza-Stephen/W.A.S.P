package com.bugstrack.interfaces;

import com.bugstrack.exceptions.CustomSQLException;
import com.bugstrack.exceptions.UserAlreadyLoggedInException;
import com.bugstrack.exceptions.UserNotLoggedInException;

public interface UserLoggedInInterface {
	
	public boolean isCurrentlyLoggedIn(int userId) throws CustomSQLException;
	
	public void logOut(int userId) throws UserNotLoggedInException, CustomSQLException;
	
	public void logIn(int userId) throws UserAlreadyLoggedInException;
	
}

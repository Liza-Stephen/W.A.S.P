package com.wasp.interfaces;

import com.wasp.entity.User;
import com.wasp.exceptions.UserCannotLoginException;

public interface LoginInterface {
	
	public User getUser(String emailId) throws UserCannotLoginException;
	
	public int updateLastLogin(User u) throws UserCannotLoginException;

}

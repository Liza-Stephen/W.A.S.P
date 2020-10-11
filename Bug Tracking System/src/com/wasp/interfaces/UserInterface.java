package com.wasp.interfaces;

import java.sql.SQLException;

import com.wasp.entity.Roles;
import com.wasp.entity.User;
import com.wasp.exceptions.FieldNotMatchingWithExistingDB;
import com.wasp.exceptions.UserAlreadyRegisteredException;
import com.wasp.exceptions.UserCannotLoginException;

public interface UserInterface {
	
	public User getUser(String emailId) throws UserCannotLoginException;
	
	public int updateLastLogin(User u);
	
	public void registerUser(User user, Roles role) throws UserAlreadyRegisteredException,FieldNotMatchingWithExistingDB, SQLException;

}

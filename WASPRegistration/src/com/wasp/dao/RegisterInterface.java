package com.wasp.dao;

import java.sql.SQLException;

import com.wasp.exceptions.FieldNotMatchingWithExistingDB;
import com.wasp.exceptions.UserAlreadyRegisteredException;

public interface RegisterInterface {
	
	public void registerUser() throws UserAlreadyRegisteredException,FieldNotMatchingWithExistingDB, SQLException;

}

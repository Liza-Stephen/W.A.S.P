package com.wasp.interfaces;

import java.sql.SQLException;

import com.wasp.entity.Roles;
import com.wasp.entity.User;
import com.wasp.exceptions.FieldNotMatchingWithExistingDB;
import com.wasp.exceptions.UserAlreadyRegisteredException;

public interface RegisterInterface {
	
	public void registerUser(User user, Roles role) throws UserAlreadyRegisteredException,FieldNotMatchingWithExistingDB, SQLException;


}

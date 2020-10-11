package com.wasp.forwards;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import com.wasp.entity.Roles;
import com.wasp.entity.User;
import com.wasp.exceptions.FieldNotMatchingWithExistingDB;
import com.wasp.exceptions.UserAlreadyRegisteredException;
import com.wasp.exceptions.UserCannotLoginException;
import com.wasp.factory.ForwardMethods;

public class RegisterForward {
	
	public static void performRegister(String email,String password,String role) {
		
		//Create a user object and provide below after fetching it from the front-end.
		
		try {
			Timestamp date = new java.sql.Timestamp(new Date().getTime());
			User tempuser = ForwardMethods.loginUser().getUser(email);
			User user = new User(tempuser.getUserId(), tempuser.getUserName(), email, password, date, tempuser.getIsRegistered());
			Roles userrole = new Roles(tempuser.getUserId(), role);
			try {
				ForwardMethods.registerUser().registerUser(user, userrole);
			} catch (UserAlreadyRegisteredException | FieldNotMatchingWithExistingDB | SQLException e) {
				//Log these exception here
			}
		} catch (UserCannotLoginException e1) {
			//Handle exception here and log
		}
		
	
	
	}

}

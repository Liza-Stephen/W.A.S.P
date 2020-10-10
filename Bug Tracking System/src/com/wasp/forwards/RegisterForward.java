package com.wasp.forwards;

import java.sql.SQLException;

import com.wasp.entity.User;
import com.wasp.exceptions.FieldNotMatchingWithExistingDB;
import com.wasp.exceptions.UserAlreadyRegisteredException;
import com.wasp.factory.ForwardMethods;
import com.wasp.interfaces.RegisterInterface;

public class RegisterForward {
	
	public static void performRegister() {
		
		//Create a user object and provide below after fetching it from the front-end.
		User user = new User(); //Change this.
		RegisterInterface registerInterface = ForwardMethods.registerUser(user);
		try {
			registerInterface.registerUser();
		} catch (UserAlreadyRegisteredException | FieldNotMatchingWithExistingDB | SQLException e) {
			// Handle exceptions here and log them as required
			
		}
		
	}
	
	
	

}

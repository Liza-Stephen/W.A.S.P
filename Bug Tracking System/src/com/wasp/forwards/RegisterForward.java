package com.wasp.forwards;

import java.sql.SQLException;

import com.wasp.entity.Roles;
import com.wasp.entity.User;
import com.wasp.exceptions.FieldNotMatchingWithExistingDB;
import com.wasp.exceptions.UserAlreadyRegisteredException;
import com.wasp.factory.ForwardMethods;
import com.wasp.interfaces.RegisterInterface;

public class RegisterForward {
	
	public static void performRegister() {
		
		//Create a user object and provide below after fetching it from the front-end.
		User user = new User(); //Change this and pass user object after fetching and creating it from the front-end
		Roles role = new Roles(userId, role); //Change this and pass role obj after creating it from the front-end
		RegisterInterface registerInterface = ForwardMethods.registerUser(user,role);
		try {
			registerInterface.registerUser();
		} catch (UserAlreadyRegisteredException | FieldNotMatchingWithExistingDB | SQLException e) {
			// Handle exceptions here and log them as required
			
		}
		
	}
	
	
	

}

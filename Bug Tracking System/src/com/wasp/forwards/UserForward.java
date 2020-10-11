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

public class UserForward {
	
	public static void performLogin(String email,String password) {
		try {
			User user = ForwardMethods.userDAO().getUser(email);
			if(user==null) {
				System.out.println("User is not logged in");
			}
			else {
				int userId;
				System.out.println(user.getPassword());
				if(user.getPassword().equals(password)) {
					Timestamp date = new Timestamp(new Date().getTime());
					User newUser = new User(user.getUserId(),user.getUserName(),email,password,date,user.getIsRegistered());
					int num = ForwardMethods.userDAO().updateLastLogin(newUser);
					if(num == 1) {
						userId = user.getUserId();
						System.out.println(userId);
						//obj.put("userId",userId);     // Set to session
					}
					System.out.println(newUser.getLastLogin());
				}
				else {
					System.out.println("Incorrect password");
				}
			}
		} catch (UserCannotLoginException e) {
			//Log exception here
		}
	}
	
	
public static void performRegister(String email,String password,String role) {
		
		//Create a user object and provide below after fetching it from the front-end.
		
		try {
			Timestamp date = new java.sql.Timestamp(new Date().getTime());
			User tempuser = ForwardMethods.userDAO().getUser(email);
			User user = new User(tempuser.getUserId(), tempuser.getUserName(), email, password, date, tempuser.getIsRegistered());
			Roles userrole = new Roles(tempuser.getUserId(), role);
			try {
				ForwardMethods.userDAO().registerUser(user, userrole);
			} catch (UserAlreadyRegisteredException | FieldNotMatchingWithExistingDB | SQLException e) {
				//Log these exception here
			}
		} catch (UserCannotLoginException e1) {
			//Handle exception here and log
		}
		
	
	
	}

}

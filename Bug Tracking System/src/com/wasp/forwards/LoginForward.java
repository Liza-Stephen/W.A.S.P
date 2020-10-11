package com.wasp.forwards;

import java.sql.Timestamp;
import java.util.Date;

import com.wasp.entity.User;
import com.wasp.exceptions.UserCannotLoginException;
import com.wasp.factory.ForwardMethods;

public class LoginForward {
	
	public static void performLogin(String email,String password) {
		try {
			User user = ForwardMethods.loginUser().getUser(email);
			if(user==null) {
				System.out.println("User is not logged in");
			}
			else {
				int userId;
				System.out.println(user.getPassword());
				if(user.getPassword().equals(password)) {
					Timestamp date = new Timestamp(new Date().getTime());
					User newUser = new User(user.getUserId(),user.getUserName(),email,password,date,user.getIsRegistered());
					int num = ForwardMethods.loginUser().updateLastLogin(newUser);
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

}

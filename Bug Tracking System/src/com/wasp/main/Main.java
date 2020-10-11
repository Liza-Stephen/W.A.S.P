package com.wasp.main;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import com.wasp.entity.Roles;
import com.wasp.entity.User;
import com.wasp.exceptions.FieldNotMatchingWithExistingDB;
import com.wasp.exceptions.UserAlreadyRegisteredException;
import com.wasp.exceptions.UserCannotLoginException;
import com.wasp.factory.ForwardMethods;

public class Main {

	private static final boolean True = false;

	public static void main(String[] args) {
//		Login Module TESTED
//		try {
//			User user = ForwardMethods.loginUser().getUser("vineetkish");
//			if(user==null) {
//				System.out.println("User is not logged in");
//			}
//			else {
//				int userId;
//				System.out.println(user.getPassword());
//				if(user.getPassword().equals("Apple")) {
//					Timestamp date = new java.sql.Timestamp(new Date().getTime());
//					User newUser = new User(user.getUserId(),user.getUserName(),"vineetkish","Apple",date,user.getIsRegistered());
//					int num = ForwardMethods.loginUser().updateLastLogin(newUser);
//					if(num == 1) {
//						userId = user.getUserId();
//						System.out.println(userId);
//						//obj.put("userId",userId);     // Set to session
//					}
//					System.out.println(newUser.getLastLogin());
//				}
//				else {
//					System.out.println("Incorrect password");
//				}
//			}
//		} catch (UserCannotLoginException e) {
//			e.printStackTrace();
//		}
		
		//Register Module working
		
//		Timestamp date = new java.sql.Timestamp(new Date().getTime());
//		User user = new User(100, "Vineet", "vineetkishore01@gmail.com", "password", date, True);
//		Roles role = new Roles(100, "Manager");
//		try {
//			ForwardMethods.registerUser().registerUser(user, role);
//		} catch (UserAlreadyRegisteredException | FieldNotMatchingWithExistingDB | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		
		

	}

}

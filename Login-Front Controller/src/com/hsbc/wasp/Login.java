package com.hsbc.wasp.controllers;

import java.sql.Timestamp;
import java.util.Date;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.hsbc.wasp.dao.UserDao;
import com.hsbc.wasp.entity.User;
import com.hsbc.wasp.exceptions.UserCannotLoginException;

public class Login {
	
	public static void loginUser(String email, String password) throws UserCannotLoginException
	{
		UserDao dao = new UserDao();
		JSONArray array = new JSONArray();
		JSONObject obj = null;
		try {
			User u = dao.getUser(email);
			if(u==null)
			{
				obj.put("message","User must register with the system first");		//Failure message				
			}
			else {
				int userId;
				if(u.getPassword().equals(password)) {
					Timestamp date = new java.sql.Timestamp(new Date().getTime());
					User newUser = new User(u.getUserId(),u.getUserName(),email,password,date,u.getIsRegistered());
					int num = dao.updateLastLogin(newUser);
					if(num == 1) {
						userId = u.getUserId();
						obj.put("userId",userId);     // Set to session
					}
				}
				else {
					obj.put("message", "Incorrect password!");
				}
			}
			array.add(obj);
			return array;
		}
		catch(Exception e) {
			throw new UserCannotLoginException("Unable to login to the system");			
		}
		
	}
}

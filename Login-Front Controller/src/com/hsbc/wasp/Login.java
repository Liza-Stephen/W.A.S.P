package com.hsbc.wasp.controllers;

import java.sql.Timestamp;
import java.util.Date;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.hsbc.wasp.dao.UserLoginDao;
import com.hsbc.wasp.entity.UserLogin;
import com.hsbc.wasp.exceptions.UserCannotLoginException;

public class Login {
	
	public static void loginUser(String email, String password) throws UserCannotLoginException
	{
		UserLoginDao dao = new UserLoginDao();
		JSONArray array = new JSONArray();
		JSONObject obj = null;
		try {
			UserLogin u = dao.getUserLogin(email);
			if(u==null)
			{
				obj.put("message","User must register with the system first");		//Failure message				
			}
			else {
				int userId;
				if(u.getPassword().equals(password)) {
					Timestamp date = new java.sql.Timestamp(new Date().getTime());
					UserLogin newUser = new UserLogin(u.getUserId(),email,password,date);
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

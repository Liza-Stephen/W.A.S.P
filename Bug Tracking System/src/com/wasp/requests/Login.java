package com.wasp.requests;

import java.sql.Timestamp;
import java.util.Date;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.wasp.dao.LoginDAO;
import com.wasp.entity.User;
import com.wasp.exceptions.UserCannotLoginException;



public class Login {
	
	public void loginUser(String email, String password) throws UserCannotLoginException
	{
		LoginDAO dao = new LoginDAO();
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
			return array; //Confirm with megha about this
		}
		catch(Exception e) {
			throw new UserCannotLoginException("Unable to login to the system");			
		}
		
	}
}

package com.bugstrack.service;

import org.json.simple.JSONObject;

import com.bugstrack.factory.ForwardMethod;
import com.bugstrack.interfaces.UserInterface;

public class RegisterUserService {
 public static void registerUser(String emailId,String password,String role)
 {
	UserInterface  users=ForwardMethod.getUserInterface();
	int userId=users.getUserIdByemail(emailId);
	String userRole=RoleService.getRole(userId);
	users.registerUser(emailId, password);
	
 }
 public static void  registerUser(JSONObject json)
 {
	 String emailId=(String ) json.get("emailId");
	 String password=(String ) json.get("password");
	 String role=(String ) json.get("role");
	 registerUser(emailId, password, role);
 }
}

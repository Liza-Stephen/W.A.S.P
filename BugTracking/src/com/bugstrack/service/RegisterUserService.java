package com.bugstrack.service;

import com.bugstrack.factory.ForwardMethod;
import com.bugstrack.interfaces.UserInterface;

public class RegisterUserService {
 public static void registerUser(String emailId,String password,String role)
 {
	UserInterface  users=ForwardMethod.getUserInterface();
	int userId=users.getUserIdByemail(emailId);
	String userRole=RoleService.getRole(userId);
	
 }
}

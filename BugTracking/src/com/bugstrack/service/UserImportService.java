package com.bugstrack.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.bugstrack.domain.User;
import com.bugstrack.factory.ForwardMethod;
import com.bugstrack.interfaces.RolesInterface;
import com.bugstrack.interfaces.UserInterface;

public class UserImportService {
public static void addUsers(JSONObject json)
{
	JSONArray array=(JSONArray)json.get("file");
	UserInterface user=ForwardMethod.getUserInterface();
	RolesInterface roles=ForwardMethod.getRoleInterface();
	String userName="",role="",emailId="";
	int userId=0;
	for(Object obj:array)
	{
		userName=(String)((JSONObject)obj).get("userName");
		role=(String)((JSONObject)obj).get("role");
		emailId=(String)((JSONObject)obj).get("emailId");
		user.addUser(new User(userName, emailId));
		userId=user.lastrowAdded();
		roles.addRoles(userId, role); 
	}
}
}

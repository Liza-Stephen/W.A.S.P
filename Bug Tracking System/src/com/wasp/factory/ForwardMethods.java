package com.wasp.factory;

import com.wasp.entity.User;
import com.wasp.interfaces.LoginInterface;
import com.wasp.interfaces.RegisterInterface;
import com.wasp.dao.LoginDAO;
import com.wasp.dao.RegisterDAO;

public class ForwardMethods {
	
	public static LoginInterface loginUser() {
		return new LoginDAO();
	}
	
	
	public static RegisterInterface registerUser(User user) {
		return new RegisterDAO(user);
	}

}

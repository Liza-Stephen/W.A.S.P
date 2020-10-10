package com.wasp.forwards;

import com.wasp.factory.ForwardMethods;
import com.wasp.interfaces.LoginInterface;

public class LoginForward {
	
	public static void performLogin() {
		LoginInterface logindao = ForwardMethods.loginUser();
		//Below, create user object here after fetching the data from the front-end.
		//logindao.updateLastLogin(u);
		
		//
		//logindao.getUser(emailId);
	}

}

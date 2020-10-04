package com.wasp.dao;

import com.wasp.entity.Users;

public class FactoryMethods {
	
	public static RegisterInterface registerUser(Users user) {
		return new RegisterDAO(user);
	}

}

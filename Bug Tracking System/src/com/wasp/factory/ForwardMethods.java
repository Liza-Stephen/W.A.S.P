package com.wasp.factory;

import com.wasp.entity.Roles;
import com.wasp.entity.User;
import com.wasp.interfaces.LoginInterface;
import com.wasp.interfaces.RegisterInterface;
import com.wasp.interfaces.UserInterface;
import com.wasp.dao.LoginDAO;
import com.wasp.dao.RegisterDAO;
import com.wasp.dao.UserDAO;

public class ForwardMethods {
	
	public static UserInterface userDAO() {
		return new UserDAO();
	}
}

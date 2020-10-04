package com.wasp.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wasp.dao.FactoryMethods;
import com.wasp.dao.RegisterInterface;
import com.wasp.entity.Users;
import com.wasp.exceptions.FieldNotMatchingWithExistingDB;
import com.wasp.exceptions.UserAlreadyRegisteredException;

public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public RegisterUser() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Receive post data above
		Users user = new Users(1, "SkullEnemyX", "Manager", "vineetkishore01@gmail.com", null, "1111");
		//Entering dummy data above
		RegisterInterface register = FactoryMethods.registerUser(user);
		try {
			register.registerUser();
		} catch (UserAlreadyRegisteredException | FieldNotMatchingWithExistingDB | SQLException e) {
			e.printStackTrace();
		}
	}

}

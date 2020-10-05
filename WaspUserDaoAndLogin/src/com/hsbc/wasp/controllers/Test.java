package com.hsbc.wasp.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsbc.wasp.dao.UserLoginDao;
import com.hsbc.wasp.entity.User;
import com.hsbc.wasp.entity.UserLogin;

public class Test extends HttpServlet {

	public Test() {
        super();
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserLoginDao dao = new UserLoginDao();
		String email = "megha18@gmail.com";
		String password = "megha18";
		try {
			UserLogin u = dao.getUserLogin(email);
			if(u==null)
			{
//				request.setAttribute("message", "User must register with the system first!");
//				rd = request.getRequestDispatcher("login.jsp");
				System.out.println("Register with the system");
			}
			else {
				if(u.getPassword().equals(password)) {
					
				}
				else {
//					request.setAttribute("message", "Incorrect password!");
//					rd = request.getRequestDispatcher("login.jsp");
					System.out.println("Check password");
				}
			}
			System.out.println(u);
		}
		catch(Exception e) {
//			request.setAttribute("message", "Cannot connect to database!");
//			rd = request.getRequestDispatcher("login.jsp");
			System.out.println("Cannot connect to databse");
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

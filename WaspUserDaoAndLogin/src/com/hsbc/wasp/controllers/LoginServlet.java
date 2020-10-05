package com.hsbc.wasp.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.util.Date;
import java.sql.Timestamp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsbc.wasp.dao.UserLoginDao;
import com.hsbc.wasp.entity.UserLogin;


public class LoginServlet extends HttpServlet {
	Connection con;
	String query;
	PreparedStatement pst;
	Statement stmt;
	ResultSet rs;
    public LoginServlet() {
        super();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserLoginDao dao = new UserLoginDao();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		RequestDispatcher rd = null;
		int userId = 0;
		
		try {
			UserLogin u = dao.getUserLogin(email);
			if(u==null)
			{
				request.setAttribute("message", "User must register with the system first!");
				rd = request.getRequestDispatcher("login.jsp");
				System.out.println("Register with the system");
			}
			else {
				if(u.getPassword().equals(password)) {
					Timestamp date = new java.sql.Timestamp(new Date().getTime());
					UserLogin newUser = new UserLogin(u.getUserId(),email,password,date);
					int num = dao.updateLastLogin(newUser);
					if(num == 1) {
						userId = u.getUserId();
						request.setAttribute("userId", userId);
						rd = request.getRequestDispatcher("mainpage.jsp");
						System.out.println("Login");
					}
				}
				else {
					request.setAttribute("message", "Incorrect password!");
					rd = request.getRequestDispatcher("login.jsp");
					System.out.println("Check password");
				}
			}
		}
		catch(Exception e) {
			request.setAttribute("message", "Cannot connect to database!");
			rd = request.getRequestDispatcher("login.jsp");
			System.out.println("Cannot connect to databse");
		}
		rd.forward(request, response);
	}
}

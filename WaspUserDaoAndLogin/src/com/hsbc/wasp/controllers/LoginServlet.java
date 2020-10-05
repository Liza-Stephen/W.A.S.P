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
		con = com.hsbc.wasp.db.DBUtility.getConnection();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String actualPassword;
		RequestDispatcher rd = null;
		int userId;
		
		try {
			query = "select * from userLogin where emailId=?";
			pst = con.prepareStatement(query);
			pst.setString(1, email);
			rs = pst.executeQuery();
			if(rs.next()) {
				userId = rs.getInt(1);
				actualPassword = rs.getString(3);
				if(actualPassword.equals(password)) {
					Timestamp date = new java.sql.Timestamp(new Date().getTime());
					
					query = "update userLogin set lastLogin=? where emailId=?"; 
					
					pst = con.prepareStatement(query);
					pst.setTimestamp(1, date);
					pst.setString(2,email);
					int num = pst.executeUpdate();
					if(num == 1) {
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
			else {
				request.setAttribute("message", "User must register with the system first!");
				rd = request.getRequestDispatcher("login.jsp");
				System.out.println("Register with the system");
			}
		}
		catch(SQLException ex) {
			ex.getStackTrace();
			request.setAttribute("message", "Cannot connect to database!");
			rd = request.getRequestDispatcher("login.jsp");
			System.out.println("Cannot connect to database");
		}
		rd.forward(request, response);
	}
}

package com.hsbc.db.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsbc.db.dao.Dao;
import com.hsbc.db.dao.DaoFactory;
import com.hsbc.db.exceptions.BugNotFoundException;


public class DevloperMarkOfClosing extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("bugname");
		Dao d= DaoFactory.getDao("Bug");
		try {
			d.MarkForClosing(name);
		} catch (BugNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}

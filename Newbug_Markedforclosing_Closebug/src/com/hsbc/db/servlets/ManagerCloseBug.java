package com.hsbc.db.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsbc.db.dao.Dao;
import com.hsbc.db.dao.DaoFactory;
import com.hsbc.db.exceptions.NotMarkedClosedException;

public class ManagerCloseBug extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id1=request.getParameter("bugid");
		int bugid=Integer.parseInt(id1);
		String date=request.getParameter("date");
		String id=request.getParameter("managerid");
		int managerid=Integer.parseInt(id);
		Dao d= DaoFactory.getDao("Bug");
		try {
			d.CloseBug(bugid,date,managerid);;
		} catch (NotMarkedClosedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}

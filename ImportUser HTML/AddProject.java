package com.bugtrack.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Servlet implementation class AddProjectServlet
 */
public class AddProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String data=request.getParameter("data");
		Object obj=null;
		try {
			obj = new JSONParser().parse(new StringReader(data));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject json=(JSONObject)obj;
		String pname=(String)json.get("pname");
		String description=(String)json.get("description");
		//Date startDate=(Date)json.get("startDate");
		JSONArray array=(JSONArray)json.get("userIds");
		List<Long> list=new ArrayList<Long>();
		for(Object j:array)
			list.add((Long)j);
		System.out.println(pname+" "+description+"  ");
		JSONArray arr=new JSONArray();
		for(Long x:list)
			arr.add(x);
		JSONObject js=new JSONObject();
		js.put("pname", data);
		js.put("description", description);
		//js.put("userIds", arr);
		response.setStatus(200);
		PrintWriter pw=response.getWriter();
		pw.println(js.toJSONString());
		pw.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type=request.getContentType();
		System.out.println(type);
		BufferedReader data=new BufferedReader(new InputStreamReader(request.getInputStream()));
		Object obj=null;
		try {
			obj = new JSONParser().parse(data);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject json=(JSONObject)obj;
		System.out.println(json);
		String pname=(String)json.get("pname");
		String description=(String)json.get("description");
		//Date startDate=(Date)json.get("startDate");
		JSONArray array=(JSONArray)json.get("userIds");
		List<Long> list=new ArrayList<Long>();
		for(Object j:array)
			list.add((Long)j);
		System.out.println(pname+" "+description+"  ");
		JSONArray arr=new JSONArray();
		for(Long x:list)
			arr.add(x);
		JSONObject js=new JSONObject();
		js.put("pname", "pankaj");
		js.put("description", "malik");
		js.put("userIds", arr);
		response.setStatus(200);
		PrintWriter pw=response.getWriter();
		pw.println(js.toJSONString());
		pw.close();
		
	}
}

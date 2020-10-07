package com.hsbc.db.dao;


public class DaoFactory {
	public static Dao getDao(String type) {
		if(type.equals("Bug"))
			return new BugDao();
		return null;
		
	}

}

package com.wasp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.wasp.entity.User;
import com.wasp.entity.Users;
import com.wasp.exceptions.FieldNotMatchingWithExistingDB;
import com.wasp.exceptions.UserAlreadyRegisteredException;

class RegisterDAO implements RegisterInterface{
	/*Tasks
	1. Create a connection as static
	2. Take the input from the user their user name, email, role and check if they
		are already registered.
	3. If registered, throw UserAlreadyRegisteredException
	4. If not then query and compare the email and role entered by the user from the form
		to be same as that stored in the database, if so then store the password entered by him
		else throw FieldNotMatchingWithExistingDatabase exception for log.
	5. Return a success status code through the Servlet.
	*/
//	Connection connection;
	Map<Integer, Users> userDataMap = new HashMap<>();
	Users user;
	
	
	//Task 1.
	public RegisterDAO(Users user) {
		
		this.user = user;
	}
	
//	static {
//		connection = DatabaseConnect.connect();
//	}

	@Override
	public void registerUser() throws UserAlreadyRegisteredException, FieldNotMatchingWithExistingDB, SQLException {
		
		Connection connection = DatabaseConnect.connect();
		//connection.setAutoCommit(false);
		//Task 2 done, Task 3.
		Statement statement1 = connection.createStatement();
		Statement statement2 = connection.createStatement();
		System.out.println(user.getUserid());
		ResultSet resultquery1 = statement1.executeQuery("select * from userLogin");
		//ResultSet resultquery2 = statement2.executeQuery("select role from users");
		
//		if(user.getLastLogin()!=null) {
//			throw new UserAlreadyRegisteredException();
//		}
		
		//Task 4
		while(resultquery1.next()) {
			String email = resultquery1.getString(4); //created field is emailId and not email in the table.
			System.out.println(email);
			System.out.println(user.getEmail());
			//String role = resultquery2.getString(3);
			if(user.getEmail().compareTo(email)==0 ) {//&& user.getRole()==role
				System.out.println(user.getPassword());
				System.out.println(user.getUserid());
				statement2.executeUpdate("update userLogin set password ='"+user.getPassword() +"' where userid="+user.getUserid());
			}
			else {
				throw new FieldNotMatchingWithExistingDB();
			}
			//statement1.close();
		}
		
		
		connection.close();
		//Task 5 to be done by the servlet
		
		
		
	}
	
	
	

}

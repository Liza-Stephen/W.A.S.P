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
	Connection connection;
	Map<Integer, Users> userDataMap = new HashMap<>();
	Users user;
	
	
	//Task 1.
	public RegisterDAO(Users user) {
		connection = DatabaseConnect.connect();
		this.user = user;
	}

	@Override
	public void registerUser() throws UserAlreadyRegisteredException, FieldNotMatchingWithExistingDB, SQLException {
		
		//Task 2 done, Task 3.
		Statement statement = connection.createStatement();
		ResultSet resultquery1 = statement.executeQuery("select * from userLogin where username ="+user.getUsername());
		ResultSet resultquery2 = statement.executeQuery("select role from user where username ="+user.getUsername());
		
		if(user.getLastLogin()!=null) {
			throw new UserAlreadyRegisteredException();
		}
		
		//Task 4
		String email = resultquery1.getString("emailid"); //created field is emailId and not email in the table.
		String role = resultquery2.getString("role");
		if(user.getEmail()==email ) {//&& user.getRole()==role
			statement.executeUpdate("update userLogin set password ="+user.getPassword() +"where username = "+user.getUsername());
		}
		else {
			throw new FieldNotMatchingWithExistingDB();
		}
		
		//Task 5 to be done by the servlet
		
		
		
	}
	
	
	

}

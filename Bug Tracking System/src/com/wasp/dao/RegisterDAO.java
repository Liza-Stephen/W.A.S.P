package com.wasp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import com.wasp.database.DatabaseConnect;
import com.wasp.entity.Roles;
import com.wasp.entity.User;
import com.wasp.exceptions.FieldNotMatchingWithExistingDB;
import com.wasp.exceptions.UserAlreadyRegisteredException;
import com.wasp.interfaces.RegisterInterface;

public class RegisterDAO implements RegisterInterface{
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
	Map<Integer, User> userDataMap = new HashMap<>();
	User user;
	Roles role;
	
	
	//Task 1.
	public RegisterDAO(User user, Roles role) {
		
		this.user = user;
		this.role = role;
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
		System.out.println(user.getUserId());
		ResultSet resultquery1 = statement1.executeQuery("select * from users");
		ResultSet resultquery2 = statement2.executeQuery("select role from roles where userid = "+ user.getUserId());
		
		
		
		//Task 4
			String roleUser = resultquery2.getString(2);
			String email = resultquery1.getString(4); //created field is emailId and not email in the table.
			Timestamp timestamp = resultquery1.getTimestamp(5);
			//String role = resultquery2.getString(3);
			if(timestamp!=null) {
				throw new UserAlreadyRegisteredException();
			}
			if(user.getEmailId().equalsIgnoreCase(email) && role.getRole().equalsIgnoreCase(roleUser) ) {
//				System.out.println(user.getPassword());
//				System.out.println(user.getUserId());
				statement2.executeUpdate("update users set password ='"+user.getPassword() +"' where userid="+user.getUserId());
			}
			else {
				throw new FieldNotMatchingWithExistingDB(user.getLastLogin());
			}
			//statement1.close();
		
		
		connection.close();
		//Task 5 to be done by the servlet
		
		
		
	}
	
	
	

}

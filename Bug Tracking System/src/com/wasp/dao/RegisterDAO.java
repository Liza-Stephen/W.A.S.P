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
	
	@Override
	public void registerUser(User user,Roles role) throws UserAlreadyRegisteredException, FieldNotMatchingWithExistingDB, SQLException {
		
		Connection connection = DatabaseConnect.connect();
		//connection.setAutoCommit(false);
		//Task 2 done, Task 3.
		Statement st1 = connection.createStatement();
		Statement st2 = connection.createStatement();
		ResultSet resultquery = st1.executeQuery("select * from roles inner join users on roles.userid = users.userid where users.userid = "+user.getUserId());
		
		//Declaring variables below
		String roleUser;
		int userId;
		String email;
		Timestamp timestamp;
		boolean isRegistered;
		
		//Task 4
		
			while(resultquery.next()) {
					roleUser = resultquery.getString("role");
					userId = resultquery.getInt("userId");
					email = resultquery.getString("emailId"); //created field is emailId and not email in the table.
					timestamp = resultquery.getTimestamp("lastLoggedIn");
					isRegistered = resultquery.getBoolean("isRegistered");
					System.out.println(roleUser+" "+email+" "+timestamp);
					//String role = resultquery2.getString(3);
					//change isRegistered to True
					if(isRegistered) {
						throw new UserAlreadyRegisteredException(userId, timestamp);
					}
					if(user.getEmailId().equalsIgnoreCase(email) && role.getRole().equalsIgnoreCase(roleUser) ) {
//						System.out.println(user.getPassword());
//						System.out.println(user.getUserId());
						st2.executeUpdate("update users set password ='"+user.getPassword() +"' where userid="+user.getUserId());
					}
					else {
						throw new FieldNotMatchingWithExistingDB(userId, user.getLastLogin());
					}
				
			}
			
			//statement1.close();
		
		
		connection.close();
		//Task 5 to be done by the servlet
		
		
		
	}
	
	
	

}

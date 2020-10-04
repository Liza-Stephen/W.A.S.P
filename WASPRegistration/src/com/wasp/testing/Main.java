package com.wasp.testing;

import java.sql.SQLException;

import com.wasp.dao.FactoryMethods;
import com.wasp.dao.RegisterInterface;
import com.wasp.entity.Users;
import com.wasp.exceptions.FieldNotMatchingWithExistingDB;
import com.wasp.exceptions.UserAlreadyRegisteredException;

public class Main {

	public static void main(String[] args) {
		Users user = new Users(1, "SkullEnemyX", "Manager", "vineetkishore0", null, "1111");
		//Entering dummy data above
		RegisterInterface register = FactoryMethods.registerUser(user);
		try {
			register.registerUser();
		} catch (UserAlreadyRegisteredException | FieldNotMatchingWithExistingDB | SQLException e) {
			e.printStackTrace();
		}

	}

}

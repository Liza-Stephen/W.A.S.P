package com.bugstrack.service;

import java.util.List;

import org.eclipse.jdt.internal.compiler.env.INameEnvironment;

import com.bugstrack.factory.ForwardMethod;
import com.bugstrack.interfaces.RolesInterface;

public class RoleService {
	public static List<Integer> getUserByRole(String role)
	{
		RolesInterface roles=ForwardMethod.getRoleInterface();
		List<Integer> users=roles.getUserByRole(role);
		return users;
	}
}

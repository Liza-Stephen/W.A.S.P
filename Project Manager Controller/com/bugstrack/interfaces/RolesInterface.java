package com.bugstrack.interfaces;

import java.util.List;

public interface RolesInterface {
   void addRoles(int userId,String role);
   List<String> getRole(int userId);
   
}

package com.niit.Backend.dao;

import java.util.List;

import com.niit.Backend.model.User;



public interface UserDAO 
{

	public boolean addUser(User user);
	  public boolean updateOnlineStatus(String status,User user);
	  public User getUser(String username);
	  
}


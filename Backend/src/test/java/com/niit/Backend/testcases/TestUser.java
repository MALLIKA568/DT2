package com.niit.Backend.testcases;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Backend.dao.UserDAO;

import com.niit.Backend.model.User;

public class TestUser 
{
static UserDAO userDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.Backend");
		context.refresh();
		
		userDAO=(UserDAO)context.getBean("userDAO");
	}
	
	

	@Test
	public void addUserTest()
	{
		User user=new User();
		 user.setUsername("Raaji");
		 user.setFirstname("Raaji");
		 user.setLastname("Papanaboina");
		 user.setPassword("0675");
		 user.setEmailId("rajipapanaboina@gmail.com");
		 user.setRole("Admin");
		 user.setIsOnline("N");
		assertTrue("Problem in Inserting User",userDAO.addUser(user));
	
	}
	
	@Test
	public void isOnlineTest()
	{
		User user=userDAO.getUser("Raaji");
		assertTrue("Problem in assertion..",userDAO.updateOnlineStatus("Y", user));
	}

}

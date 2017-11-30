package com.niit.Backend.testcases;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Backend.dao.ForumDAO;
import com.niit.Backend.dao.UserDAO;
import com.niit.Backend.model.Forum;
import com.niit.Backend.model.User;

public class ForumTest 
{
	Logger log = LoggerFactory.getLogger(ForumTest.class);
	
	@Autowired
	ForumDAO forumDAO;
	
	@Autowired
	Forum forum;
	
	@Autowired
	AnnotationConfigApplicationContext context;
	
	public ForumTest()
	{
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.Backend");
		context.refresh();

		forumDAO = (ForumDAO) context.getBean("forumDAO");
		forum = (Forum) context.getBean("forum");
		
	}
	public void addforum()
	{
		log.info("Add forum Test started");
		  
		   forum.setDescription("sdfghgjdkdkluruighfkjdsfdks");
		   forum.setUsername("mallika");
		  
		   forum.setDate_time("DATE_TIME");
		   
		 
		   log.info("Add Blog Test end");
	}
	public void deleteBlog(int id)
	{
		log.info("Delete Success initiated.");
		forum = forumDAO.getForum(id);
		forumDAO.deleteForum(id);
		log.info("Delete Success");
	}
	 public void UpdateForum(int id)
	  	{
	  		log.info("Update Success initiated.");
	  		forum = forumDAO.getForum(id);
	  		forumDAO.updateForum(forum);
	  		log.info("Update Success");
	  	}
	public static void main(String[] args) 
	{
	   BlogDAOTestCase tblog = new BlogDAOTestCase ();
//		tblog.ForumAdd();
	

//		tblog.deleteBlog();
	
		
		System.out.println("Success");
	}
}
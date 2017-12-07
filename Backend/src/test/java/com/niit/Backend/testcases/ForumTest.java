package com.niit.Backend.testcases;

import org.junit.Test;
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
static ForumDAO forumDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.raaji.CollaborationProject");
		context.refresh();
		
		forumDAO=(ForumDAO)context.getBean("forumDAO");
	}
	
	@Test
	public void addBlogTest()
	{
		Forum forum=new Forum();
		
		forum.setForumId(1017);
		forum.setForumName("Java");
		forum.setForumContent("It contains simple java Concept");
		forum.setUsername("papanaboina");
		forum.setStatus("A");
	    forum.setCreateDate(new java.util.Date());;
		
		assertTrue("Problem in Inserting Forum",forumDAO.addForum(forum));
	
	}
    /*
	@Test
	public void getForumTest()
	{
		ForumPart forum=forumDAO.getForum(1016);
        assertNotNull("forum not found",forum);
        
        System.out.println("Forum Name is:"+forum.getForumName());
        System.out.println("Forum Content is:"+forum.getForumContent());
	}
	
	@Test
	public void getAllForumTest()
	{
		List<ForumPart> forum=(List<forumDAO>).getAllForums();
        assertNotNull("forum list not found",forumList.get(0));
        
        for(ForumPart forum:forumList)
        {
        System.out.println("Forum Id"+forum.getForumId()+"-----"+"Forum Name"+forum.getForumName());
	    }
     }
	
	@Test
	public void deleteForumTest()
	{
		ForumPart forum=(ForumPart)forumDAO.getforum(2017);
		assertTrue("Problem in deletion",forumDAO.deleteForum(forum));
	}
	
	@Test
	public void updateForumTest()
	{
		ForumPart forum=(ForumPart)forumDAO.getforum(1016);
		forum.setForumContent("Features of java, variables, collections ,Multithreading, Strings ");
        forum.setForumName("Core java");
        assertTrue("Problem in updation", forumDAO.updateForum(forum));
	}
	
	@Test
	public void approveForumTest()
	{
		ForumPart forum=(ForumPart)forumDAO.getForum(1016);
	    assertTrue("Problem in updation",forumDAO.updateForum(forum));
	}
	
	@Test
	public void rejectForumTest()
	{
		ForumPart forum=(ForumPart)forumDAO.getForum(1016);
	    assertTrue("Problem in updation",forumDAO.rejectForum(forum));
	}*/
	
}
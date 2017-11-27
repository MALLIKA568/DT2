package com.niit.Backend.testcases;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Backend.dao.BlogDAO;
import com.niit.Backend.model.Blog;



public class BlogDAOTestCase
{
	
	static BlogDAO blogDAO;
	
	
	@BeforeClass
	public static void initalize()
	{
		System.out.println("Starting into Initializaed Blog Test case ");
		
		AnnotationConfigApplicationContext annotationConfigAppContext=new AnnotationConfigApplicationContext();
		annotationConfigAppContext.scan("com.niit.Backend");
		annotationConfigAppContext.refresh();
		
		blogDAO=(BlogDAO)annotationConfigAppContext.getBean("blogDAO");
	
		System.out.println("Ending into Initializaed Blog Test case ");
	}

	@Test
	public void createBlogTest() 
	{
		
		System.out.println("Starting into Creating Blog Test case ");
		Blog blog=new Blog();
		
		blog.setBlogId(1001);
		blog.setBlogName("Jithin");
		blog.setBlogContent("Jithin is studying in niit with konkepudi");
		blog.setUserid("jtnrdy@gmail.com");
		blog.setCreateDate(new java.util.Date());
		blog.setStatus("NA");
		blog.setLikes(0);
		
		assertTrue("Problem in blog creation",blogDAO.createBlog(blog));
		
		System.out.println("Ending... into  Create Blog Test case ");
	}

}

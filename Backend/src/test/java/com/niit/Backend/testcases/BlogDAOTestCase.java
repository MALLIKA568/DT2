package com.niit.Backend.testcases;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Backend.dao.BlogDAO;
import com.niit.Backend.model.Blog;
import com.niit.Backend.model.User;

public class BlogDAOTestCase 
{
	Logger log = LoggerFactory.getLogger(BlogDAOTestCase.class);
	
	@Autowired
	BlogDAO blogDAO;
	
	@Autowired
	Blog blog;
	
	@Autowired
	AnnotationConfigApplicationContext context;
	
	public BlogDAOTestCase()
	{
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.Backend");
		context.refresh();

		blogDAO = (BlogDAO) context.getBean("blogDAO");
		blog = (Blog) context.getBean("blog");
		
	}
   public void blogAdd()
   {
	   log.info("Add blog Test started");
	  
	   blog.setDescription("sdfghgjdkdkluruighfkjdsfdks");
	   blog.setUsername("mallika");
	   blog.setBlog_title("aaaaaa");
	   blog.setDate_time("DATE_TIME");
	   
	   blogDAO.addBlog(blog);
	   log.info("Add Blog Test end");
   }
   public void UpdateBlog()
  	{
  		log.info("Update Success initiated.");
  		blog = blogDAO.getBlog("testBlog");
  		blogDAO.updateBlog(blog);
  		log.info("Update Success");
  	}
   public void deleteBlog()
	{
		log.info("Delete Success initiated.");
		blog = blogDAO.getBlog("testBlog");
		blogDAO.deleteBlog(blog);
		log.info("Delete Success");
	}
  
   public void list()
	{
		log.info("List Users");
		List<Blog> list = blogDAO.getAllBlogs();
		int size = list.size();
		for(int index = 0; index < size; index++)
		{
			System.out.print("username = "+list.get(index).getUsername());
			System.out.println("\t Blog_title = "+list.get(index).getBlog_title());
		}
	}
   public static void main(String[] args) 
	{
	   BlogDAOTestCase tblog = new BlogDAOTestCase ();
		tblog.blogAdd();
	//tblog.getBlogDetails();
//	tblog.UpdateBlog();
//		tblog.deleteBlog();
		//tblog.list();
		
		System.out.println("Success");
	}
   
}
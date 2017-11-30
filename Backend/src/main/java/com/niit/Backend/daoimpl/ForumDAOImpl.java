package com.niit.Backend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.Backend.dao.ForumDAO;
import com.niit.Backend.dao.UserDAO;
import com.niit.Backend.model.Forum;
import com.niit.Backend.model.User;

@SuppressWarnings("deprecation")
@Repository("forumDAO")
@EnableTransactionManagement


public class ForumDAOImpl implements ForumDAO 
{
private static final Logger log = LoggerFactory.getLogger(ForumDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public ForumDAOImpl(SessionFactory sessionFactory) 
	{
		try 
		{
			this.sessionFactory = sessionFactory;
			log.info("Connection Established Successfully");
		} 
		catch (Exception ex) 
		{
			log.error("Failed to establish connection");
			ex.printStackTrace();
		}
	}

	public boolean addForum(Forum forum) {
		log.info("Add Forum Method Started");
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(forum);
			log.info("Add Forum Method Success");
			return true;
		}
		catch(Exception ex)
		{
			log.error("Add Forum has an Error");
			ex.printStackTrace();
			return false;
		}
	}

	public boolean deleteForum(int id) {
		log.info("Delete Forum method Started");
		try
		{
			log.info("Delete forum Success");
			sessionFactory.getCurrentSession().delete(id);
			return true;
		}
		catch(Exception ex)
		{
			log.info("Delete Forum Unsuccessful");
			ex.printStackTrace();
			return false;
		}
	}

	public boolean updateForum(Forum forum) {
		// TODO Auto-generated method stub
		return false;
	}

	public Forum getForum(int id) {
		log.debug("Starting of Method Get User "+id);
		try
		{
			Forum forum =  sessionFactory.getCurrentSession().get(Forum.class, id);
			forum.setErrorCode("200");
			forum.setErrorMsg("User Found");
			return forum;
		}
		catch(Exception ex)
		{
			User user = new User();
			ex.printStackTrace();
			user.setErrorCode("404");
			user.setErrorMsg("User Not Found");
			return null;
		}
	}

	public List<Forum> getUserForums(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Forum> getForumList() {
		// TODO Auto-generated method stub
		return null;

   }
}
package com.niit.Backend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Backend.dao.ForumDAO;
import com.niit.Backend.dao.UserDAO;
import com.niit.Backend.model.Forum;
import com.niit.Backend.model.User;

@SuppressWarnings("deprecation")
@Repository("forumDAO")
@EnableTransactionManagement


public class ForumDAOImpl 
{
	@Autowired
	SessionFactory sessionFactory;
	
	public ForumDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public boolean addForum(Forum forum) 
	{
		try
		{
		sessionFactory.getCurrentSession().save(forum);
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}
	}


	
	public boolean updateForum(Forum forum) {
		
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(forum);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception has occured..........."+e);
			return false;
		}
		
	}

	@Transactional
	
	public boolean deleteForum(Forum forum) {
		try
		{
			sessionFactory.getCurrentSession().delete(forum);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception has occured..........."+e);
			return false;
		}
		
	}

	
	public Forum getForum(int forumId) {
		Session session=sessionFactory.openSession();
		Forum forum =(Forum)session.get(Forum.class,forumId);
		session.close();
		return forum;
	}

	
	public List<Forum> getAllForums() {
		Session session=sessionFactory.openSession();
		List<Forum> forumList =(List<Forum>)session.createQuery("from Forum");
		session.close();
		return forumList;
	}

	
	public boolean approveForum(Forum forum) {
		try
		{
			forum.setStatus("A");
			sessionFactory.getCurrentSession().update(forum);	
		    return true;
	    }
        catch(Exception e)
		{
        	System.out.println("Exception has occured"+e);
        	return false;
		}
   }		
	
	
	public boolean rejectForum(Forum forum) {
		try
		{
			forum.setStatus("N");
			sessionFactory.getCurrentSession().update(forum);	
		    return true;
	    }
        catch(Exception e)
		{
        	System.out.println("Exception has occured"+e);
        	return false;
		}
   }		
}
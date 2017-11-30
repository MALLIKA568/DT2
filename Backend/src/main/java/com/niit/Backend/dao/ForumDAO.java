package com.niit.Backend.dao;

import java.util.List;

import com.niit.Backend.model.Forum;

public interface ForumDAO
{

	public boolean addForum(Forum forum);
	
	public boolean deleteForum(int id);
	
	public boolean updateForum(Forum forum);
	
	public Forum getForum(int id);
	
	public List<Forum> getUserForums(String username);
	
	public List<Forum> getForumList();
	
}
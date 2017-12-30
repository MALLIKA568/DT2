package com.niit.Backend.dao;


import java.util.List;

import com.niit.Backend.model.BlogComment;

public interface CommentDAO
{
	
	public boolean addBlogComment(BlogComment blogComment);

	public boolean deleteComment(int id);
	
	public List<BlogComment> getBlogComments(String blog_id);
}
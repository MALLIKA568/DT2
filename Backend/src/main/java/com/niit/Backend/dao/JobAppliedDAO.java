package com.niit.Backend.dao;
import java.util.List;

import com.niit.Backend.model.JobApplied;

public interface JobAppliedDAO 
{
	
	public boolean applyNew(JobApplied jobApplied);
	
	public List<JobApplied> listByUser(String username);
	
	public List<JobApplied> listByCompany();
	
}

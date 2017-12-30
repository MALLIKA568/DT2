package com.niit.Backend.dao;


import java.util.List;

import com.niit.Backend.model.Event;



public interface EventDAO
{
	public boolean addEvent(Event event);
	
	public boolean deleteEvent(int id);
	
	public Event getEvent(int id);
	
	public List<Event> listEvent();
	
}

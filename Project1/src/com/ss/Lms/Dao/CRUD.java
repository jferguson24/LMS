package com.ss.Lms.Dao;

@SuppressWarnings("hiding")
public interface CRUD<Object> {
	
	
	public boolean create(Object object);
	
	public boolean retrieve(String name);
	
	public boolean update(String name, Object object);
	
	public boolean delete(String name);
	
	public void printList();
	
	public String display();
}

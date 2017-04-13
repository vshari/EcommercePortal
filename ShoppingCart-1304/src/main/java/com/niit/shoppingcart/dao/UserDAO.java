package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.domain.User;

public interface UserDAO {
	
	public List<User> list();
	
	public User getUser(int id);
	
	public User getUserByName(String name);
	
	public boolean save(User user);
	
	public boolean update(User user);
	
	public boolean validate(String name, String password);
	
	

}

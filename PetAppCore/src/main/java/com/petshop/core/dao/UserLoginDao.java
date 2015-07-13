package com.petshop.core.dao;

import com.petshop.core.model.User;


public interface UserLoginDao {

	/**
	 * This method is to check user login
	
	 */
	public User checkUser(String uname, String password) throws Exception;
}

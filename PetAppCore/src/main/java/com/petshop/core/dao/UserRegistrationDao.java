package com.petshop.core.dao;

import com.petshop.core.model.User;


public interface UserRegistrationDao {

	/**
	 * This method is for registering user to shopping cart.
	 
	 */
	public void userRegistration(User user) throws Exception;

}

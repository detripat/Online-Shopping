package com.petshop.core.service;

import com.petshop.core.model.User;

public interface UserLoginService {
	/**
	 * This method is to check user login
	 * 
	 * @param uname
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public User checkUser(String uname, String password) throws Exception;
}

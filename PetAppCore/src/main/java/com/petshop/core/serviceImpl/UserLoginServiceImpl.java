package com.petshop.core.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshop.core.dao.UserLoginDao;
import com.petshop.core.model.User;
import com.petshop.core.service.UserLoginService;

@Service("userLoginService")
public class UserLoginServiceImpl implements UserLoginService {

	@Autowired
	UserLoginDao userLoginDao;

	/**
	 * This method is to check user login
	 * 
	
	 */
	public User checkUser(String uname, String password) throws Exception {

		return userLoginDao.checkUser(uname, password);
	}

}

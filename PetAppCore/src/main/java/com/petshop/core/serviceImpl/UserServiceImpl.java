package com.petshop.core.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshop.core.dao.UserDao;
import com.petshop.core.model.User;
import com.petshop.core.service.UserService;


@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDao userdao;
	
	public List<User> getUserDatails() throws Exception{
		
		
		return userdao.getUserDatails();
		
	}

}

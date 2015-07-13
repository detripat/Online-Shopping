package com.petshop.core.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.petshop.core.dao.UserRegistrationDao;
import com.petshop.core.model.User;
import com.petshop.core.service.UserRegistrationService;

@Service("userRegistrationService")
@Transactional
public class UserRegistrationServiceImpl implements UserRegistrationService {

	@Autowired
	UserRegistrationDao userRegistrationDao;

	public void userRegistration(User user) throws Exception {
		userRegistrationDao.userRegistration(user);
	}

}

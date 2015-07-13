package com.petshop.core.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.petshop.core.dao.UserDao;
import com.petshop.core.model.Product;
import com.petshop.core.model.User;


@Repository("userDao")
public class UserDaoImpl  implements UserDao{
	
	@PersistenceContext
	private EntityManager entitymanager;
	
	public List<User> getUserDatails() throws Exception {
		
		/*
		List<User> Userlist = entitymanager.createQuery("from Product",
				Product.class).getResultList();*/
		List<User>userlist=entitymanager.createQuery("From User", User.class).getResultList();
		return userlist;
	}

	
}

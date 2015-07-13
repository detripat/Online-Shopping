package com.petshop.core.daoImpl;



import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.petshop.core.dao.UserLoginDao;
import com.petshop.core.model.User;

@Repository("userLoginDao")
public class LoginDaoImpl implements UserLoginDao {

	
	@PersistenceContext
	private EntityManager entitymanager;

	/**
	 * This method is to check user login
	 * 
	 * @param uname
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public User checkUser(String uname, String password) throws Exception {
		
		

		User userDetails = new User();
		String sql = "from User where USERNAME=:USERNAME and PASSWORD=:PASSWORD";
		Query query = entitymanager.createQuery(sql);
				
		
		query.setParameter("USERNAME", uname);
		query.setParameter("PASSWORD", password);
		User user = (User) query.getSingleResult();
		if (user != null) {
			userDetails = user;
			System.out.println("User Retrieved from DB::" + user);
		}
		return userDetails;
	
		
		}

}

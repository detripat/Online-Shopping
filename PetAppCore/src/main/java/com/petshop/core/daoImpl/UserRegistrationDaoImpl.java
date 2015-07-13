package com.petshop.core.daoImpl;

/**
 * User registration
 * 
 * @author ranjit
 *
 */
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.petshop.core.dao.UserRegistrationDao;
import com.petshop.core.model.User;

@Repository("userRegistrationDao")
public class UserRegistrationDaoImpl implements UserRegistrationDao {

	
	@PersistenceContext
	private EntityManager entitymanager;

	/**
	 * This method is for registering user to shopping cart.
	 * 
	 * @param user
	 * @throws Exception
	 */
	public void userRegistration(User user) throws Exception {
		
		entitymanager.persist(user);
		entitymanager.flush();
		
	
	}

}

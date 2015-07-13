package com.petshop.core.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.petshop.core.model.User;


public interface UserDao {
	
	
	
	
	public List<User> getUserDatails() throws Exception;

}

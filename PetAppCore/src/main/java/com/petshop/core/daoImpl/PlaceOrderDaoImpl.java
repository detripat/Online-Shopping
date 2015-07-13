package com.petshop.core.daoImpl;


import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.petshop.core.dao.PlaceOrderDao;
import com.petshop.core.model.Order;
import com.petshop.core.model.OrderDetails;
import com.petshop.core.model.User;

@Repository("placeOrderDao")
public class PlaceOrderDaoImpl implements PlaceOrderDao {

	
	@PersistenceContext
	private EntityManager entitymanager;

	/**
	 * This method is used for product checkout
	 */
	public void productCheckOut(String userId, String transactionID,
			BigDecimal totalPrice, String status, List<String> cartItems) {
		
		
		

		Order order = new Order();
		User user = new User();
		OrderDetails orderDetails=new OrderDetails();
		//.orderDetails.setProductPrice(productPrice);
		
		//user.setUserId(Long.parseLong(userId));
		user.setUserId(Long.valueOf(userId));
		System.out.println("After userId");

		order.setUser(user);
		order.setTransactionId(transactionID);
		order.setTransactionStatus(status);
		order.setTransactionAmount(totalPrice);
		
		entitymanager.merge(order);

	}
}

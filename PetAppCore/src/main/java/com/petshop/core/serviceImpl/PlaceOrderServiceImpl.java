package com.petshop.core.serviceImpl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshop.core.dao.PlaceOrderDao;
import com.petshop.core.service.PlaceOrderService;

@Service("placeOrderService")
public class PlaceOrderServiceImpl implements PlaceOrderService {

	@Autowired
	PlaceOrderDao placeOrderDao;

	/**
	 * This Method is used to checkout the product from shopping cart
	 * 
	 
	 */
	public void productCheckOut(String userId, String transactionID,
			BigDecimal totalPrice, String status, List<String> cartItems)
			throws Exception {
		placeOrderDao.productCheckOut(userId, transactionID, totalPrice,
				status, cartItems);

	}

}

package com.petshop.core.service;

import java.math.BigDecimal;
import java.util.List;

public interface PlaceOrderService {
	/**
	 * This Method is used to checkout the product from shopping cart
	 * 
	 * @param userId
	 * @param transactionID
	 * @param totalPrice
	
	 */
	public void productCheckOut(String userId, String transactionID,
			BigDecimal totalPrice, String status, List<String> cartItems)
			throws Exception;
}

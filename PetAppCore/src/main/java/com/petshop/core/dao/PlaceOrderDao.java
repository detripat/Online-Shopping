package com.petshop.core.dao;

import java.math.BigDecimal;
import java.util.List;

public interface PlaceOrderDao {
	/**
	 * This Method is used to checkout the product from shopping cart
	 
	 */
	public void productCheckOut(String userId, String transactionID,
			BigDecimal totalPrice, String status, List<String> cartItems)
			throws Exception;
}

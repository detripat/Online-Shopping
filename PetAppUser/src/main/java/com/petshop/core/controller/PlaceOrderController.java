package com.petshop.core.controller;

import java.math.BigDecimal;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.petshop.core.model.User;
import com.petshop.core.service.PlaceOrderService;


@RestController
public class PlaceOrderController {

	private static final Logger logger = Logger
			.getLogger(ProductController.class);

	@Autowired
	PlaceOrderService placeOrderService;

	
	@RequestMapping(value = "/paymentCheckOut/{userId}/{transactionID}/{totalPrice}/{status}/{cartItems}", method = RequestMethod.GET, produces = {
			"application/xml", "application/json" })
	@ResponseBody
	@Transactional
	public void checkOutPlaceOrder(@PathVariable("userId") String userId,
			@PathVariable("transactionID") String transactionID,
			@PathVariable("totalPrice") BigDecimal totalPrice,
			@PathVariable("status") String status,
			@PathVariable("cartItems") List<String> cartItems) {
		logger.info("Inside ChekOutController" + cartItems);
		System.out.println("aaaaaa "+totalPrice);
		User user=new User();
		//user.setUserId(1L);
		
		System.out.println("nnnnnnnn "+userId);
		System.out.println("ssss"+cartItems);
		
//		 userId="1";
//		 transactionID="2";
		
		try{
			placeOrderService.productCheckOut(userId, transactionID, totalPrice, status, cartItems);
		}catch(Exception e){
			
			System.out.println("@@@@@@"+e);
		}
		
		
		
		
	}
}

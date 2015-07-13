package com.petshop.core.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.petshop.core.model.Product;
import com.petshop.core.service.ProductService;

@RestController
public class ProductController {

	private static final Logger logger = Logger
			.getLogger(ProductController.class);

	@Autowired(required = true)
	ProductService productService;

	
	@RequestMapping(value = "/default", method = RequestMethod.GET)
	public ModelAndView printWelcome(ModelMap model) {
		return new ModelAndView("default");
	}

	
	@RequestMapping(value = "/productMaster", method = RequestMethod.GET, produces = {
			"application/xml", "application/json" })
	@ResponseBody
	public List<Product> getProductList() {
		logger.info("Inside getProductList Controller");
		List<Product> prodlist = null;
		try {
			prodlist = productService.getAllProduct();
		} catch (Exception e) {
			logger.error("Exception occured during get all product list : " + e);
		}
		logger.info("Product list size " + prodlist.size());

		return prodlist;
	}

}

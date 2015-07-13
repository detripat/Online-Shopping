package com.petshop.admin.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.petshop.core.model.Product;
import com.petshop.core.model.ProductCatagory;
import com.petshop.core.service.ProductService;


@RestController
public class ProductController {
	
	@Autowired
	ProductService productservice;
	
	
	@RequestMapping(value = "/productMasterAdmin", method = RequestMethod.GET, produces = {
			"application/xml", "application/json" })
	@ResponseBody
	public List<Product> getProductList(){
		
		List<Product> productlist=null;
		try{
			
			productlist=productservice.getAllProduct();
			System.out.println("product list is "+productlist);
			
		}catch(Exception e){e.printStackTrace();}
		
		
		return productlist;
		
	}
	
	
	@RequestMapping(value = "/productAddAdmin/{prodName}/{prodDesc}/{prodPrice}/{prodQuant}/{category}", method = RequestMethod.GET, produces = {
			"application/xml", "application/json" })
	@Transactional
	public void addProducts(@PathVariable("prodName") String productName,
			@PathVariable("prodDesc") String productDescription,
			@PathVariable("prodPrice") BigDecimal productPrice,
			@PathVariable("prodQuant") Long productQuantity,
			@PathVariable("category") Long productCategory) {

		System.out.println("Inside Add Product Controller : " + productName);

		Product product = new Product();
		product.setProductId((long) 12);
		product.setProductName(productName);
		product.setProductDescription(productDescription);
		product.setProductPrice(productPrice);
		product.setProductQuantity(productQuantity);
		
		
		
		ProductCatagory prodCat = new ProductCatagory();
		prodCat.setCatagoryId(productCategory);
		System.out.println("xxxxxxxxxx "+productCategory);
		product.setProductCatagory(prodCat);	

		try {
			System.out.println("inside produt add");
			productservice.addProduct(product);
			System.out.println("zzzzz:"+product);
		
		} catch (Exception e) {
			System.out.println("aaaaaaaaaaa "+e);
		}

	}
	
	@RequestMapping(value = "/productDeleteAdmin/{prodId}", method = RequestMethod.GET, produces = {
			"application/xml", "application/json" })
	@Transactional
	public void deleteProduct(@PathVariable("prodId") Long productId) {
		try {
			System.out.println("inside deleting method");
			productservice.deleteProduct(productId);
		} catch (Exception e) {
			System.out.println("@@@@@@@@@@"+e);
			
		}
	}
	
	@RequestMapping(value = "/productEditAdmin/{product}", method = RequestMethod.GET, produces = {
			"application/xml", "application/json" })
	@Transactional
	public void modifyProduct(@PathVariable("product") Product product){
		
		
		
		try{
			productservice.updateProduct(product);
		}catch(Exception e){
			System.out.println("inside update"+e);
		}
		
		
		
		
	}
	

}

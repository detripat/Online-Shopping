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
import com.petshop.core.service.CategoryService;

@RestController
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping(value = "/allCategoryAdmin", method = RequestMethod.GET, produces = {
			"application/xml", "application/json" })
	@ResponseBody
	 public List<ProductCatagory>processCategory(){
		 List<ProductCatagory> productCat=null;
		 try{
			 productCat=categoryService.getAllCategory();
			 System.out.println("Category Details");
		 }catch(Exception e){e.printStackTrace();}
		 
		 return productCat;
		 
	 }
	
	
	
	
	@RequestMapping(value = "/addcategory/{categoryName}", method = RequestMethod.GET, produces = {
			"application/xml", "application/json" })
   @Transactional
	public void  doCategory(@PathVariable("categoryName") String categoryName) {
		System.out.println("Inside  Category Controller");
		   
		
		
		ProductCatagory prodcat=new ProductCatagory();
		
		prodcat.setCatagoryName(categoryName);
		

		try {
			System.out.println("inside category add");
			
			categoryService.addCategory(prodcat);
			//System.out.println("zzzzz:"+product);
		
		} catch (Exception e) {
			System.out.println("aaaaaaaaaaa "+e);
		}

	}
	
	
	

}

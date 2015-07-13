package com.petshop.core.serviceImpl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshop.core.dao.ProductDao;
import com.petshop.core.model.Product;
import com.petshop.core.service.ProductService;


@Service("productService")
public class ProductServicesImpl implements ProductService {

	@Autowired
	ProductDao productDao;

	
	public void deleteProduct(Long id) throws Exception {

		productDao.deleteProduct(id);
	}

	
	public List<Product> searchByProduct(String productName) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * This method is to search product by category
	 
	 */
	public List<Product> searchByCategory(String categoryName) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * This method is to get all products.
	
	 */
	public List<Product> getAllProduct() throws Exception {
		return productDao.getAllProduct();
	}

	public void addProduct(Product product) throws Exception {
		productDao.addProduct(product);

	}

	public int updateProduct(Product product) throws Exception {
		return productDao.updateProduct(product);
		
	}

}

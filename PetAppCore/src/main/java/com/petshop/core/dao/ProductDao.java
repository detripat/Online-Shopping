package com.petshop.core.dao;

import java.math.BigDecimal;
import java.util.List;

/**
 * Product DAO 
 * 
 * @author ranjit
 *
 */

import com.petshop.core.model.Product;

public interface ProductDao {
	/**
	 * This method is to add product

	 */
	public void addProduct(Product product) throws Exception;

	/**
	 * This method is to delete product
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public void deleteProduct(Long id) throws Exception;

	/**
	 * This method is to update products
	 * 
	 
	 */
	public int updateProduct(Product product) throws Exception;

	/**
	 * This method is to search product by product name
	
	 */
	public List<Product> searchByProduct(String productName) throws Exception;

	/**
	 * This method is to search product by category
	
	 */
	public List<Product> searchByCategory(String categoryName) throws Exception;

	
	public List<Product> getAllProduct() throws Exception;

}

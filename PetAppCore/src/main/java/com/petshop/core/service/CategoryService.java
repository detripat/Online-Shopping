package com.petshop.core.service;

import java.util.List;

import com.petshop.core.model.ProductCatagory;

public interface CategoryService {
	public List<ProductCatagory> getAllCategory() throws Exception;

	public void addCategory(ProductCatagory productcategory)
			throws Exception;

	public void editCategory(String categoryName, String categoryDesc)
			throws Exception;

	public void deleteCategory(int categoryID) throws Exception;
}

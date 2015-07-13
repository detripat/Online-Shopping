package com.petshop.core.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshop.core.dao.CategoryDao;
import com.petshop.core.model.ProductCatagory;
import com.petshop.core.service.CategoryService;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryDao categoryDao;

	public List<ProductCatagory> getAllCategory() throws Exception {
		return categoryDao.getAllCategory();

	}

	public void addCategory(ProductCatagory productcategory)
			throws Exception {
		categoryDao.addCategory(productcategory);
		// TODO Auto-generated method stub

	}

	public void editCategory(String categoryName, String categoryDesc)
			throws Exception {
		// TODO Auto-generated method stub

	}

	public void deleteCategory(int categoryID) throws Exception {
		// TODO Auto-generated method stub

	}

}

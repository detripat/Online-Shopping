package com.petshop.core.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.petshop.core.dao.CategoryDao;
import com.petshop.core.model.ProductCatagory;

@Repository("categoryDao")
public class CategoryDaoImpl implements CategoryDao {

	
	@PersistenceContext
	private EntityManager entitymanager;
	

	public List<ProductCatagory> getAllCategory() throws Exception {
		
		String sql = "from ProductCatagory";
		Query query = entitymanager.createQuery(sql);
		List<ProductCatagory> proCatList = query.getResultList();
		
		return proCatList;
	}

	public void addCategory(ProductCatagory productcategory)
			throws Exception {
		
		System.out.println("Inside daoimplCategory");
		ProductCatagory  prodCat= new ProductCatagory();
	
		
		prodCat.setCatagoryName(productcategory.getCatagoryName());
		
		//entitymanager.persist(productcategory);
		entitymanager.merge(productcategory);
		entitymanager.flush();
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

package com.petshop.core.daoImpl;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;

import com.petshop.core.dao.ProductDao;
import com.petshop.core.model.Product;

@Repository("productDao")
//@Transactional
public class ProductDaoImpl implements ProductDao {

	
	@PersistenceContext
	private EntityManager entitymanager;

	//Product product;

	/**
	 * This method is to delete product
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public void deleteProduct(Long productId) throws Exception {
		System.out.println("Inside remove method");
		Product product = (Product)entitymanager.find(Product.class, new Long(productId));
		System.out.println("Products are->>"+product.getProductId());
		
		entitymanager.remove(product);
		entitymanager.flush();
		
		System.out.println("sucessfully removed.....");
		//System.out.println("Removed form dasta base"+product.getProductName());
		

	}

	/**
	 * This method is to search product by product name
	 * 
	 * @param productName
	 * @return
	 * @throws Exception
	 */
	public List<Product> searchByProduct(String productName) throws Exception {
		return null;
	}

	/**
	 * This method is to search product by category
	 * 
	 * @param categoryName
	 * @return
	 * @throws Exception
	 */
	public List<Product> searchByCategory(String categoryName) throws Exception {
		return null;
	}

	/**
	 * This method is to get all products.
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Product> getAllProduct() throws Exception {

		List<Product> productList = entitymanager.createQuery("from Product",
				Product.class).getResultList();
		/*for (Product product : productList) {
			System.out.println("Product List::" + product);
		}*/
		
		return productList;
	}

	//@Transactional	
	public void addProduct(Product prod) throws Exception {
		
		
		
		System.out.println(prod.getProductName());
		System.out.println(prod.getProductDescription());
		System.out.println(prod.getProductCatagory());
		System.out.println(prod.getProductId());
		
		System.out.println("calling merge");
		
		entitymanager.merge(prod);
		entitymanager.flush();
		
	/*	
	try{
		entitymanager.getTransaction().begin();
		
	
		entitymanager.merge(prod);
		
		
		entitymanager.flush();
		
		entitymanager.getTransaction().commit();
		
		System.out.println("products are sucess fully added"+prod);
	}catch(Exception e){
		e.printStackTrace();
		System.out.println("Exception occured"+e);
	}*/

	}

	public int updateProduct(Product product) throws Exception {
		// TODO Auto-generated method stub
	
		Product prod=new Product();
		prod.setProductName(product.getProductName());
		prod.setProductDescription(product.getProductDescription());
		prod.setProductQuantity(product.getProductQuantity());
		prod.setProductId(product.getProductId());
		//prod.s
		
		//prod=entitymanager.createQuery("Update Product product set");
		
		
		//entitymanager.merge(prod);
		return 0;
		
		
	}

}

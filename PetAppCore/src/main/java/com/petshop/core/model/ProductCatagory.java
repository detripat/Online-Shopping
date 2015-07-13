package com.petshop.core.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "PRODUCT_CATG")
@SequenceGenerator(name = "CATAGORY_SEQUENCE", sequenceName = "product_catg_seq", initialValue = 1, allocationSize = 1)
public class ProductCatagory implements Serializable {

	/**
	 * <code>serialVersionUID</code> indicates/is used for.
	 */
	private static final long serialVersionUID = 8710480264842495979L;

	/**
	 * catagoryId
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CATAGORY_SEQUENCE")
	@Column(name = "CATG_ID", nullable = false)
	private Long catagoryId;

	/**
	 * catagoryName
	 */
	@Column(name = "CATG_NAME")
	private String catagoryName;

	/**
	 * products
	 */
	@Transient
	private Set<Product> products = new HashSet<Product>(0);

	/**
	 * isActive
	 */
	/*
	 * @Column(name = "IS_ACTIVE") private String isActive;
	 */

	/**
	 * Get the catagoryId.
	 * 
	 * @return Returns the catagoryId as a Long.
	 */
	public Long getCatagoryId() {
		return this.catagoryId;
	}

	/**
	 * Set the catagoryId to the specified value.
	 * 
	 * @param catagoryId
	 *            The catagoryId to set.
	 */
	public void setCatagoryId(Long catagoryId) {
		this.catagoryId = catagoryId;
	}

	/**
	 * Get the catagoryName.
	 * 
	 * @return Returns the catagoryName as a String.
	 */
	public String getCatagoryName() {
		return this.catagoryName;
	}

	/**
	 * Set the catagoryName to the specified value.
	 * 
	 * @param catagoryName
	 *            The catagoryName to set.
	 */
	public void setCatagoryName(String catagoryName) {
		this.catagoryName = catagoryName;
	}

	/**
	 * Get the products.
	 * 
	 * @return Returns the products as a Set.
	 */
	public Set<Product> getProducts() {
		return this.products;
	}

	/**
	 * Set the products to the specified value.
	 * 
	 * @param products
	 *            The products to set.
	 */
	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	/**
	 * Get the isActive.
	 * 
	 * @return Returns the isActive as a String.
	 */
	/*
	 * public String getIsActive() { return this.isActive; }
	 *//**
	 * Set the isActive to the specified value.
	 * 
	 * @param isActive
	 *            The isActive to set.
	 */
	/*
	 * public void setIsActive(String isActive) { this.isActive = isActive; }
	 */

}

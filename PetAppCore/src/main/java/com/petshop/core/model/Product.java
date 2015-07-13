package com.petshop.core.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Entity
@Table(name = "PRODUCT")
@SequenceGenerator(name = "PRODUCT_SEQ", sequenceName = "PRODUCT_SEQ", initialValue = 1, allocationSize = 1)
@Component(value = "product")
@Scope(value = "session")

public class Product implements Serializable {

	/**
	 * <code>serialVersionUID</code> indicates/is used for.
	 */
	private static final long serialVersionUID = 1526114439842962472L;

	/**
	 * productId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCT_SEQ")
	@Column(name = "PRODUCT_ID", nullable = false)
	private Long productId;

	/**
	 * productCatagory
	 */
	@ManyToOne
	@JoinColumn(name = "PRODUCT_CATG_ID")
	private ProductCatagory productCatagory;

	/**
	 * productPicture
	 */
	@ManyToOne
	@JoinColumn(name = "PRODUCT_PIC_ID")
	private ProductPicture productPicture;

	/**
	 * productName
	 */
	@Column(name = "PRODUCT_NAME")
	private String productName;

	/**
	 * productPrice
	 */
	@Column(name = "PRODUCT_PRICE")
	private BigDecimal productPrice;

	/**
	 * productQuantity
	 */
	@Column(name = "PRODUCT_QUANTITY")
	private Long productQuantity;

	/**
	 * productDesc
	 */
	@Column(name = "PRODUCT_DESC")
	private String productDescription;

	/**
	 * productPictures
	 */
	@Transient
	private Set<ProductPicture> productPictures = new HashSet<ProductPicture>(0);

	/**
	 * orderDetailses
	 */
	@Transient
	private Set<OrderDetails> orderDetailses = new HashSet<OrderDetails>(0);

	/**
	 * selectedRowInSearchProduct
	 */
	@Transient
	private boolean selectedRowInSearchProduct;

	/**
	 * selectedRowInShoppingCartDetails
	 */
	@Transient
	private boolean selectedRowInShoppingCartDetails;

	/**
	 * userEnteredQuantity
	 */
	@Transient
	private Long userEnteredQuantity;

	/**
	 * isActive
	 */
	/*
	 * @Column(name = "IS_ACTIVE") private String isActive;
	 */

	/**
	 * Get the productId.
	 * 
	 * @return Returns the productId as a Long.
	 */
	public Long getProductId() {
		return this.productId;
	}

	/**
	 * Set the productId to the specified value.
	 * 
	 * @param productId
	 *            The productId to set.
	 */
	public void setProductId(Long productId) {
		this.productId = productId;
	}

	/**
	 * Get the productName.
	 * 
	 * @return Returns the productName as a String.
	 */
	public String getProductName() {
		return this.productName;
	}

	/**
	 * Set the productName to the specified value.
	 * 
	 * @param productName
	 *            The productName to set.
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * Get the productPrice.
	 * 
	 * @return Returns the productPrice as a BigDecimal.
	 */
	public BigDecimal getProductPrice() {
		return this.productPrice;
	}

	/**
	 * Set the productPrice to the specified value.
	 * 
	 * @param productPrice
	 *            The productPrice to set.
	 */
	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}

	/**
	 * Get the productQuantity.
	 * 
	 * @return Returns the productQuantity as a Long.
	 */
	public Long getProductQuantity() {
		return this.productQuantity;
	}

	/**
	 * Set the productQuantity to the specified value.
	 * 
	 * @param productQuantity
	 *            The productQuantity to set.
	 */
	public void setProductQuantity(Long productQuantity) {
		this.productQuantity = productQuantity;
	}

	/**
	 * Get the selectedRowInSearchProduct.
	 * 
	 * @return Returns the selectedRowInSearchProduct as a boolean.
	 */
	public boolean isSelectedRowInSearchProduct() {
		return this.selectedRowInSearchProduct;
	}

	/**
	 * Set the selectedRowInSearchProduct to the specified value.
	 * 
	 * @param selectedRowInSearchProduct
	 *            The selectedRowInSearchProduct to set.
	 */
	public void setSelectedRowInSearchProduct(boolean selectedRowInSearchProduct) {
		this.selectedRowInSearchProduct = selectedRowInSearchProduct;
	}

	/**
	 * Get the userEnteredQuantity.
	 * 
	 * @return Returns the userEnteredQuantity as a Long.
	 */
	public Long getUserEnteredQuantity() {
		return this.userEnteredQuantity;
	}

	/**
	 * Set the userEnteredQuantity to the specified value.
	 * 
	 * @param userEnteredQuantity
	 *            The userEnteredQuantity to set.
	 */
	public void setUserEnteredQuantity(Long userEnteredQuantity) {
		this.userEnteredQuantity = userEnteredQuantity;
	}

	/**
	 * Get the productCatagory.
	 * 
	 * @return Returns the productCatagory as a ProductCatagory.
	 */
	public ProductCatagory getProductCatagory() {
		return this.productCatagory;
	}

	/**
	 * Set the productCatagory to the specified value.
	 * 
	 * @param productCatagory
	 *            The productCatagory to set.
	 */
	public void setProductCatagory(ProductCatagory productCatagory) {
		this.productCatagory = productCatagory;
	}

	/**
	 * Get the productPicture.
	 * 
	 * @return Returns the productPicture as a ProductPicture.
	 */
	public ProductPicture getProductPicture() {
		return this.productPicture;
	}

	/**
	 * Set the productPicture to the specified value.
	 * 
	 * @param productPicture
	 *            The productPicture to set.
	 */
	public void setProductPicture(ProductPicture productPicture) {
		this.productPicture = productPicture;
	}

	/**
	 * Get the selectedRowInShoppingCartDetails.
	 * 
	 * @return Returns the selectedRowInShoppingCartDetails as a boolean.
	 */
	public boolean isSelectedRowInShoppingCartDetails() {
		return this.selectedRowInShoppingCartDetails;
	}

	/**
	 * Set the selectedRowInShoppingCartDetails to the specified value.
	 * 
	 * @param selectedRowInShoppingCartDetails
	 *            The selectedRowInShoppingCartDetails to set.
	 */
	public void setSelectedRowInShoppingCartDetails(
			boolean selectedRowInShoppingCartDetails) {
		this.selectedRowInShoppingCartDetails = selectedRowInShoppingCartDetails;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((this.productId == null) ? 0 : this.productId.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Product other = (Product) obj;
		if (this.productId == null) {
			if (other.productId != null) {
				return false;
			}
		} else if (!this.productId.equals(other.productId)) {
			return false;
		}
		return true;
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

	/**
	 * @return the productDescription
	 */
	public String getProductDescription() {
		return this.productDescription;
	}

	/**
	 * @param productDescription
	 *            the productDescription to set
	 */
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	/**
	 * @return the productPictures
	 */
	public Set<ProductPicture> getProductPictures() {
		return this.productPictures;
	}

	/**
	 * @param productPictures
	 *            the productPictures to set
	 */
	public void setProductPictures(Set<ProductPicture> productPictures) {
		this.productPictures = productPictures;
	}

	/**
	 * @return the orderDetailses
	 */
	public Set<OrderDetails> getOrderDetailses() {
		return this.orderDetailses;
	}

	/**
	 * @param orderDetailses
	 *            the orderDetailses to set
	 */
	public void setOrderDetailses(Set<OrderDetails> orderDetailses) {
		this.orderDetailses = orderDetailses;
	}

}

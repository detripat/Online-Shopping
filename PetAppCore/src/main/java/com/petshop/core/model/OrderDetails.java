package com.petshop.core.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ORDER_DETAILS")
public class OrderDetails implements Serializable {

	/**
	 * <code>serialVersionUID</code> indicates/is used for.
	 */
	private static final long serialVersionUID = -6185659245870721843L;
	/**
	 * id
	 */
	@EmbeddedId
	private OrderDetailsId id;

	/**
	 * productQuantity
	 */
	@Column(name = "PRODUCT_QUANTITY")
	private Long productQuantity;

	/**
	 * productPrice
	 */
	@Column(name = "PRODUCT_PRICE")
	private BigDecimal productPrice;

	/**
	 * Get the id.
	 * 
	 * @return Returns the id as a OrderDetailsId.
	 */
	public OrderDetailsId getId() {
		return this.id;
	}

	/**
	 * Set the id to the specified value.
	 * 
	 * @param id
	 *            The id to set.
	 */
	public void setId(OrderDetailsId id) {
		this.id = id;
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

}

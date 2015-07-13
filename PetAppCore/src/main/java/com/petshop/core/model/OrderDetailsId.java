
package com.petshop.core.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class OrderDetailsId implements Serializable {

	
	private static final long serialVersionUID = -5208607248488924306L;

	/**
	 * order
	 */
	@ManyToOne
	@JoinColumn(name = "Order_Id", insertable = true, updatable = false)
	private Order order;

	/**
	 * product
	 */
	@ManyToOne
	@JoinColumn(name = "PRODUCT_ID", insertable = true, updatable = false)
	private Product product;

	/**
	 * @return the order
	 */
	public Order getOrder() {
		return this.order;
	}

	/**
	 * @param order
	 *            the order to set
	 */
	public void setOrder(Order order) {
		this.order = order;
	}

	/**
	 * @return the product
	 */
	public Product getProduct() {
		return this.product;
	}

	/**
	 * @param product
	 *            the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

}

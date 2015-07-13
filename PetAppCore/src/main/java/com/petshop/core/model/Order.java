package com.petshop.core.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "order_master")
@SequenceGenerator(name = "ORDER_SEQUENCE", sequenceName = "order_seq", initialValue = 1, allocationSize = 1)
public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8041503926629067479L;

	/**
	 * orderId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDER_SEQUENCE")
	@Column(name = "ORDER_ID")
	private Long orderId;

	/**
	 * user
	 */
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User user;

	/**
	 * transactionId
	 */
	@Column(name = "transaction_id")
	private String transactionId;

	/**
	 * transactionAmount
	 */
	@Column(name = "transaction_amount")
	private BigDecimal transactionAmount;

	/**
	 * transactionStatus
	 */
	@Column(name = "transaction_status")
	private String transactionStatus;

	@OneToMany(mappedBy = "id.order", cascade = { CascadeType.PERSIST })
	private Set<OrderDetails> orderDetailses = new HashSet<OrderDetails>(0);

	/**
	 * @return the orderId
	 */
	public Long getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId
	 *            the orderId to set
	 */
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the transactionId
	 */
	public String getTransactionId() {
		return transactionId;
	}

	/**
	 * @param transactionId
	 *            the transactionId to set
	 */
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	/**
	 * @return the transactionAmount
	 */
	public BigDecimal getTransactionAmount() {
		return transactionAmount;
	}

	/**
	 * @param transactionAmount
	 *            the transactionAmount to set
	 */
	public void setTransactionAmount(BigDecimal transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	/**
	 * @return the transactionStatus
	 */
	public String getTransactionStatus() {
		return transactionStatus;
	}

	/**
	 * @param transactionStatus
	 *            the transactionStatus to set
	 */
	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	/**
	 * @return the orderDetailses
	 */
	public Set<OrderDetails> getOrderDetailses() {
		return orderDetailses;
	}

	/**
	 * @param orderDetailses
	 *            the orderDetailses to set
	 */
	public void setOrderDetailses(Set<OrderDetails> orderDetailses) {
		this.orderDetailses = orderDetailses;
	}

}
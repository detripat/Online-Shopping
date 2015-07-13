package com.petshop.core.model;

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

@Entity
@Table(name = "PRODUCT_PIC")
@SequenceGenerator(name = "PRODUCT_PIC_SEQ", sequenceName = "PRODUCT_PIC_SEQ", initialValue = 1, allocationSize = 1)
public class ProductPicture implements java.io.Serializable {

	/**
	 * <code>serialVersionUID</code> indicates/is used for.
	 */
	private static final long serialVersionUID = 8721213501906741703L;

	/**
	 * productPictureId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCT_PIC_SEQ")
	@Column(name = "PRODUCT_PIC_ID")
	private Long productPictureId;


	/**
	 * picName
	 */
	@Column(name = "PIC_NAME")
	private String pictureName;

	/**
	 * products
	 */
	@Transient
	private Set<Product> products = new HashSet<Product>(0);

	/**
	 * Get the productPictureId.
	 * 
	 * @return Returns the productPictureId as a Long.
	 */
	public Long getProductPictureId() {
		return this.productPictureId;
	}

	/**
	 * Set the productPictureId to the specified value.
	 * 
	 * @param productPictureId
	 *            The productPictureId to set.
	 */
	public void setProductPictureId(Long productPictureId) {
		this.productPictureId = productPictureId;
	}


	/**
	 * Get the pictureName.
	 * 
	 * @return Returns the pictureName as a String.
	 */
	public String getPictureName() {
		return this.pictureName;
	}

	/**
	 * Set the pictureName to the specified value.
	 * 
	 * @param pictureName
	 *            The pictureName to set.
	 */
	public void setPictureName(String pictureName) {
		this.pictureName = pictureName;
	}

}

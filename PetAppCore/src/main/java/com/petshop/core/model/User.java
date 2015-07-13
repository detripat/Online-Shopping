package com.petshop.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "USER")
@SequenceGenerator(name = "USERS_SEQUENCE", sequenceName = "user_seq", initialValue = 1, allocationSize = 1)
@Component(value = "user")
@Scope(value = "session")
public class User implements java.io.Serializable {

	private static final long serialVersionUID = -9183397117112149419L;

	/**
	 * userId
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERS_SEQUENCE")
	@Column(name = "USER_ID")
	private Long userId;

	/**
	 * userName
	 */
	@Column(name = "USERNAME")
	private String userName;

	/**
	 * password
	 */
	@Column(name = "PASSWORD")
	private String password;

	/**
	 * firstName
	 */
	@Column(name = "FIRST_NAME")
	private String firstName;

	/**
	 * middleName
	 */
	@Column(name = "MIDDLE_NAME")
	private String middleName;

	/**
	 * lastName
	 */
	@Column(name = "LAST_NAME")
	private String lastName;

	/**
	 * addressLine1
	 */
	@Column(name = "ADDRESS_LINE1")
	private String addressLine1;

	/**
	 * addressLine2
	 */
	@Column(name = "ADDRESS_LINE2")
	private String addressLine2;

	/**
	 * city
	 */
	@Column(name = "CITY")
	private String city;

	/**
	 * state
	 */
	@Column(name = "STATE")
	private String state;

	/**
	 * userType
	 */
	@Column(name = "USER_TYPE")
	private String userType;

	/*@Transient
	private boolean ValidUser;*/

	@Column(name = "EMAIL")
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return this.userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return this.userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return this.firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return this.middleName;
	}

	/**
	 * @param middleName
	 *            the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return this.lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

/*	*//**
	 * @return the addressLine1
	 */
	public String getAddressLine1() {
		return this.addressLine1;
	}

	/**
	 * @param addressLine1
	 *            the addressLine1 to set
	 */
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	/**
	 * @return the addressLine2
	 */
	public String getAddressLine2() {
		return this.addressLine2;
	}

	/**
	 * @param addressLine2
	 *            the addressLine2 to set
	 */
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return this.city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return this.state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the userType
	 */
	public String getUserType() {
		return this.userType;
	}

	/**
	 * @param userType
	 *            the userType to set
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}

	

}

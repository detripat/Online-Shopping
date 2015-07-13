package com.petshop.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ROLE_MASTER")
@SequenceGenerator(name = "ROLE_SEQUENCE", sequenceName = "roles_sequence", initialValue = 1, allocationSize = 1)
public class Role implements java.io.Serializable {

	/**
	 * <code>serialVersionUID</code> indicates/is used for.
	 */
	private static final long serialVersionUID = 8701963114949564686L;

	/**
	 * roleId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROLE_SEQUENCE")
	@Column(name = "ROLE_ID")
	private Long roleId;

	/**
	 * roleName
	 */
	@Column(name = "ROLE_NAME")
	private String roleName;

	/**
	 * featureId
	 */
	@Column(name = "FEATURE_ID")
	private String featureId;

	/**
	 * Get the roleId.
	 * 
	 * @return Returns the roleId as a Long.
	 */
	public Long getRoleId() {
		return this.roleId;
	}

	/**
	 * Set the roleId to the specified value.
	 * 
	 * @param roleId
	 *            The roleId to set.
	 */
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	/**
	 * Get the roleName.
	 * 
	 * @return Returns the roleName as a String.
	 */
	public String getRoleName() {
		return this.roleName;
	}

	/**
	 * Set the roleName to the specified value.
	 * 
	 * @param roleName
	 *            The roleName to set.
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * Get the featureId.
	 * 
	 * @return Returns the featureId as a String.
	 */
	public String getFeatureId() {
		return this.featureId;
	}

	/**
	 * Set the featureId to the specified value.
	 * 
	 * @param featureId
	 *            The featureId to set.
	 */
	public void setFeatureId(String featureId) {
		this.featureId = featureId;
	}

}

package com.ecomvn.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "role")
public class Role {
	@Id
	@Column(length=3, nullable = false, unique = true)
	private String id;
	
	@Column(length = 40, nullable = false, unique = true)
	private String name;
	
	@Column(columnDefinition = "TEXT", nullable = true)
	private String description;
	
	public Role(String id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public Role() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return this.getName()+ ": " + this.getDescription();
	}
}

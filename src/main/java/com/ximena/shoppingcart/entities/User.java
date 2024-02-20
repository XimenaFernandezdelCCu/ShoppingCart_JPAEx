package com.ximena.shoppingcart.entities;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="USERS")
public class User {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)  for auto_increment 
	//@GenericGenerator(name="user_id", strategy="com.ximena.shoppingcart.CustomIdGenerator") deprecated 
	
	@GeneratedValue(generator = "custom-id")
    @GenericGenerator(name = "custom-id", type = com.ximena.shoppingcart.generators.CustomIdGenerator.class)
	@Column(name = "USER_ID")
	private java.math.BigDecimal userId;
	private String name; 
	private String lastName;
	private String bio;
	private String email;
	private String areaOfInterest;
	
	public java.math.BigDecimal getUserId() {
		return userId;
	}
	public void setUserId(java.math.BigDecimal userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAreaOfInterest() {
		return areaOfInterest;
	}
	public void setAreaOfInterest(String areaOfInterest) {
		this.areaOfInterest = areaOfInterest;
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", lastName=" + lastName + ", bio=" + bio + ", email="
				+ email + ", areaOfInterest=" + areaOfInterest + "]";
	}
	
	

	
}

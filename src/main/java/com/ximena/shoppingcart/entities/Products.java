package com.ximena.shoppingcart.entities;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Products {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@GeneratedValue(generator = "custom-id")
    @GenericGenerator(name = "custom-id", type = com.ximena.shoppingcart.generators.CustomIdGenerator.class)
	private java.math.BigDecimal productId;
	private String name; 
	private double price;
	@Lob
	private byte[] image;
	private String description;
	private int totalProductsInventory;
	private boolean status;
	
	public java.math.BigDecimal getProductId() {
		return productId;
	}
	public void setProductId(java.math.BigDecimal productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getTotalProductsInventory() {
		return totalProductsInventory;
	}
	public void setTotalProductsInventory(int totalProductsInventory) {
		this.totalProductsInventory = totalProductsInventory;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	} 
	

}

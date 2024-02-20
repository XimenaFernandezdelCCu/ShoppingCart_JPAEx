package com.ximena.shoppingcart.entities;

import java.util.List;

//import java.sql.Date;


import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="ORDER_HISTORY")
public class Order {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@GeneratedValue(generator = "custom-id")
    @GenericGenerator(name = "custom-id", type = com.ximena.shoppingcart.generators.CustomIdGenerator.class)
	private java.math.BigDecimal orderId;
	
	@Temporal(TemporalType.DATE)
	private java.util.Date orderDate;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="USER_ID")
	private User user;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "PRODUCT_ID")
	private Product products;

	public java.math.BigDecimal getOrderId() {
		return orderId;
	}

	public void setOrderId(java.math.BigDecimal orderId) {
		this.orderId = orderId;
	}

	public java.util.Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(java.util.Date date) {
		this.orderDate = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProducts() {
		return products;
	}

	public void setProducts(Product products) {
		this.products = products;
	}

	
	
	
	

}

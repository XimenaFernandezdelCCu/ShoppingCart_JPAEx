package com.ximena.shoppingcart.entities;

//import java.sql.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="ORDER_HISTORY")
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int orderId;
	
	@Temporal(TemporalType.DATE)
	private java.util.Date orderDate;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="USER_ID", nullable= false)
	private User user;
	
	//@OneToMany(cascade=CascadeType.ALL)
	//@JoinColumn(name = "ORDER_ID" , nullable= false)
	//private List<Products> products;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
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

	
	
	
	

}

package com.ximena.shoppingcart.entities;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="WISHLIST")
public class Wishlist {
	
	@Id
	@GeneratedValue(generator = "custom-id")
    @GenericGenerator(name = "custom-id", type = com.ximena.shoppingcart.generators.CustomIdGenerator.class)
	private java.math.BigDecimal wishId;
	
	private java.math.BigDecimal userId;
	
	private java.math.BigDecimal productId;
	

}

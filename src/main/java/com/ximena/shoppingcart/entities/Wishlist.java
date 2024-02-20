package com.ximena.shoppingcart.entities;

import org.hibernate.annotations.GenericGenerator;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="WISHLIST")
public class Wishlist {
	
	@Id
	@GeneratedValue(generator = "custom-id")
    @GenericGenerator(name = "custom-id", type = com.ximena.shoppingcart.generators.CustomIdGenerator.class)
	private java.math.BigDecimal wishId;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="USER_ID")
	private User userId;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "PRODUCT_ID")
	private Product productId;

	public java.math.BigDecimal getWishId() {
		return wishId;
	}

	public void setWishId(java.math.BigDecimal wishId) {
		this.wishId = wishId;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public Product getProductId() {
		return productId;
	}

	public void setProductId(Product productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "Wishlist [wishId=" + wishId + ", userId=" + userId + ", productId=" + productId + "]";
	}
	
	
	

}

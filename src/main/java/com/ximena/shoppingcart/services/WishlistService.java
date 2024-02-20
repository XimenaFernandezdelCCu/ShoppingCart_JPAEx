package com.ximena.shoppingcart.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ximena.shoppingcart.entities.Wishlist;

@Service
public interface WishlistService {

	public java.math.BigDecimal generateID();
	
	//public ResponseEntity<Object> insertProduct(java.math.BigDecimal[] idArray, java.math.BigDecimal id );
	public ResponseEntity<Object> insertProduct(Map<String, java.math.BigDecimal[]> idArray, java.math.BigDecimal id );

	public List<Wishlist> getWishlistByUserId(BigDecimal userId);

	public ResponseEntity<Object> removeProduct(Map<String, BigDecimal[]> productIdArray, BigDecimal userId);

	public ResponseEntity<Object> deleteWishlist(BigDecimal userId);
}


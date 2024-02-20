package com.ximena.shoppingcart.services;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface WishlistService {

	public java.math.BigDecimal generateID();
	
	//public ResponseEntity<Object> insertProduct(java.math.BigDecimal[] idArray, java.math.BigDecimal id );
	public ResponseEntity<Object> insertProduct(Map<String, java.math.BigDecimal[]> idArray, java.math.BigDecimal id );
}

package com.ximena.shoppingcart.services;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ximena.shoppingcart.entities.Order;
import com.ximena.shoppingcart.entities.Product;

@Service
public interface OrderService {
	
	public java.math.BigDecimal generateID();

	public Optional<Order> getOneOrder(BigDecimal arg);

	public Product getOrderProducts(BigDecimal arg);

	public ResponseEntity<Object> buyProduct(Map<String, Object[]> productIdArray, BigDecimal userId);
	

}

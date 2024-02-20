package com.ximena.shoppingcart.services;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ximena.shoppingcart.entities.Order;
import com.ximena.shoppingcart.entities.Product;
import com.ximena.shoppingcart.repos.OrdersRepository;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrdersRepository repository;
	
	// ------------  Returns Id based on Existing Ids. 
	public java.math.BigDecimal generateID() {
		try {
			List<java.math.BigDecimal> existingIds = repository.findAllIds();
			BigDecimal maxId = Collections.max(existingIds);
			BigDecimal newId = maxId.add(BigDecimal.ONE);
			return newId;
		} catch (NoSuchElementException e) {
			return BigDecimal.ONE; 
		}
	}
	
	// -------------
	public Optional<Order> getOneOrder(java.math.BigDecimal arg){
		return repository.findById(arg);
	}

	public Product getOrderProducts(java.math.BigDecimal arg){
		Optional<Order> myOrder = repository.findById(arg);
		Product orderProduct = myOrder.get().getProducts();
		return orderProduct;
	}
}

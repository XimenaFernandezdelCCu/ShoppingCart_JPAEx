package com.ximena.shoppingcart.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ximena.shoppingcart.entities.Order;
import com.ximena.shoppingcart.entities.Product;
import com.ximena.shoppingcart.entities.User;
import com.ximena.shoppingcart.repos.OrdersRepository;
import com.ximena.shoppingcart.repos.ProductsRepository;
import com.ximena.shoppingcart.repos.UsersRepository;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrdersRepository repository;
	@Autowired 
	private UsersRepository usersRepository;
	@Autowired
	private ProductsRepository productRepository;
	
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
	
	// "Buy" products: creates an order and fixes the inventory
	public ResponseEntity<Object> buyProduct(Map<String, Object[]> productIdArray, BigDecimal userId){
		Object[] productIds = productIdArray.get("products");
		
		try {
			List<Order> createdOrders = new ArrayList<>();
			Optional<User> user = usersRepository.findById(userId);
			
		for (Object productObj : productIds) {
			
			Map<String, Object> productMap = (Map<String, Object>)productObj;
			int productIdInt = (int)productMap.get("productId");
			int productQuantity = (int)productMap.get("quantity");
			BigDecimal productId = BigDecimal.valueOf(productIdInt);
			//BigDecimal productId = (BigDecimal)((Map)productObj).get("productId");
			//int quantity = (Integer)((Map)productObj).get("quantity");
			
			Optional<Product> product = productRepository.findById(productId);
			int totalProductsInventory = product.get().getTotalProductsInventory();
			String productName = product.get().getName();
			
			if(totalProductsInventory <=0) {
				String message = "There is no more inventory for the product "+productName;
				return ResponseEntity.badRequest().body(message);
			} else if (totalProductsInventory-productQuantity <0 ) {
				String message = "There isn't enought inventory of "+productName+" to complete purchase.";
				return ResponseEntity.badRequest().body(message);
				
			}
			product.get().setTotalProductsInventory(totalProductsInventory-productQuantity);
			
			Date date = new Date();
			//Date orderDate, User user, Product products
			Order order = new Order(date , user.get(), product.get());
			createdOrders.add(order);
			repository.save(order);
		}
		return ResponseEntity.ok(createdOrders);
		} catch (NoSuchElementException e) {
			String message = "Couldn't find the User with ID: " + userId +
					". Or one of the product Id's provided is incorrect. Please Check the information and try again.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
		}
		
	}
}

package com.ximena.shoppingcart.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ximena.shoppingcart.entities.Order;
import com.ximena.shoppingcart.entities.User;
import com.ximena.shoppingcart.repos.OrdersRepository;
import com.ximena.shoppingcart.repos.UsersRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UsersRepository repository;
	@Autowired
	private OrdersRepository OrderRepository;
	
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
	
	// ------------  Returns Single User by Name or Email
	public List<User> getOneUser(String arg){
		if (arg.contains("@")) {
			return repository.findByEmail(arg);
		} else {
			return repository.findByName(arg);
		}
	}
	
	// ------------ Saves New User to the DB 
	public ResponseEntity<Object> insertNewUser(User user) {
		
		ArrayList<String> existingEmails = repository.findAllEmail();
		String newEmail = user.getEmail();
		
		if(existingEmails.contains(newEmail)) {
			String message = "User with email " + newEmail + " already exists.";
            return ResponseEntity.status(HttpStatus.CONFLICT).body(message);
		}
		
		User savedUser = repository.save(user);
	    return ResponseEntity.ok(savedUser);
		
	}
	
	// ------------  Edits a user's (found by their id) email and area of interest. 
	public ResponseEntity<Object> editUser(Map<String, Object> changes, java.math.BigDecimal id){
		Optional<User> optionalUser = repository.findById(id);
		if (!optionalUser.isPresent()) {
			String message = "Couldn't find User with ID: " + id + ". Please try with another id.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
		}	
		User user = optionalUser.get();
		user.setEmail((String) changes.get("email"));
		user.setAreaOfInterest((String) changes.get("areaOfInterest"));
        repository.save(user); 
        
        return ResponseEntity.ok(user); 
	}
	
	// ------------ Deletes a User
	public ResponseEntity<Object> deleteUser(java.math.BigDecimal id){
		
		Optional<User> optionalUser = repository.findById(id);
		if (!optionalUser.isPresent()) {
			String message = "Couldn't find User with ID: " + id + ". Please try with another id.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
		}	
		
		User user = optionalUser.get();
		
		List<Order> userOrders = OrderRepository.findByUser(user);
		for (Order order : userOrders) {
			order.setProducts(null);
			OrderRepository.save(order);
			OrderRepository.delete(order);
		}
		
		repository.delete(user);
        return ResponseEntity.ok(user); 
	}

	
	

}

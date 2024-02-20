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

import com.ximena.shoppingcart.entities.Product;
import com.ximena.shoppingcart.entities.User;
import com.ximena.shoppingcart.entities.Wishlist;
import com.ximena.shoppingcart.repos.ProductsRepository;
import com.ximena.shoppingcart.repos.UsersRepository;
import com.ximena.shoppingcart.repos.WishlistRepository;

@Service
public class WishlistServiceImpl implements WishlistService {
	
	@Autowired
	private WishlistRepository repository;
	@Autowired
	private UsersRepository userRepository;
	@Autowired
	private ProductsRepository productsRepository;

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
	
	// ----------- Get Wishlist from User ID
	public List<Wishlist> getWishlistByUserId(BigDecimal userId){
		Optional<User> user = userRepository.findById(userId);
		return repository.findByUserId(user.get());
	}
	
	
	// ------------  ADD Products to Wishlist 
	public ResponseEntity<Object> insertProduct(Map<String, java.math.BigDecimal[]> idArray, java.math.BigDecimal id ){
		try {
			Optional<User> user = userRepository.findById(id);
		java.math.BigDecimal[] idArrayVals = idArray.get("products");
		for (java.math.BigDecimal productId : idArrayVals) {
			Wishlist wishlist = new Wishlist();
			wishlist.setUserId(user.get());
			Optional<Product> product = productsRepository.findById(productId);
			wishlist.setProductId(product.get());
			repository.save(wishlist);
		}
		
		return ResponseEntity.ok(repository.findByUserId(user.get())); 
		} catch (NoSuchElementException e) {
			String message = "Couldn't find the Product with ID: " + id + ". Please try with another id.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
		}
		
	}
	
	// ------------ Remove Products from Wishlist
	public ResponseEntity<Object> removeProduct(Map<String, BigDecimal[]> productIdArray, BigDecimal userId){
		// Get the User and their name
		Optional<User> user = userRepository.findById(userId);
		String userName = user.get().getName() + user.get().getLastName();
		
		// Get the Array of the products to delete:
		BigDecimal[] idArrayVals = productIdArray.get("products");
		
		// Get all the User's Wishlists 
		List<Wishlist> allProductsinWhishlistbyUser = repository.findByUserId(user.get());
		
		//Create an Array to store Deleted Products 
		List<Product> deletetedProducts = new ArrayList<>();
		
		//Loop the products to delete:
		for (BigDecimal productId : idArrayVals ) {
			
			try {
				//Get the Product by the id provided:
				Optional<Product> product = productsRepository.findById(productId);
				if (product != null) {
			    	deletetedProducts.add(product.get());
			    	
			    	for (Wishlist wishlist : allProductsinWhishlistbyUser ) {
			    		Product productInList = wishlist.getProductId();
			    		BigDecimal productInListId = productInList.getProductId();
			    		System.out.println("--------- id of products in list: "+ productInListId + "------ id to delete: "+ productId );
			    		if(productInListId.equals(productId)) {
			    			System.out.println("--------- IN ---------");
			    			repository.delete(wishlist);
			    			break;
			    		}
			    	
			    	}
			    } 
			} catch (NoSuchElementException e) {
				String message = "Couldn't find the Product with ID: " + productId + ". Please try with another id.";
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
			}
			  	
		}
		
		String message = "Deleted the following products from " + userName + "'s Wishlist.";
		return ResponseEntity.ok(deletetedProducts);
		 
	}
	
	
		

}

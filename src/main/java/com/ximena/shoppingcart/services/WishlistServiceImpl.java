package com.ximena.shoppingcart.services;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	// ------------  ADD Products to Wishlist 
	public ResponseEntity<Object> insertProduct(Map<String, java.math.BigDecimal[]> idArray, java.math.BigDecimal id ){
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
	}
	
	// ----------- Get Wishlist from User ID
	public List<Wishlist> getWishlistByUserId(BigDecimal userId){
		Optional<User> user = userRepository.findById(userId);
		return repository.findByUserId(user.get());
	}
	
		

}

package com.ximena.shoppingcart.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ximena.shoppingcart.entities.Wishlist;
import com.ximena.shoppingcart.repos.WishlistRepository;
import com.ximena.shoppingcart.services.WishlistService;

@RestController
@RequestMapping("/wishlist")
public class WishlistController {
	
	@Autowired
	private WishlistRepository repository;
	@Autowired
	private WishlistService service;
	
	// ------ Get Wishlist by User
	@GetMapping("/{id}")
	public List<Wishlist> getWishlistByUserId(@PathVariable("id") java.math.BigDecimal userId){
		return service.getWishlistByUserId(userId);
		
	}
	
	@PostMapping("/save/{arg}")
	public ResponseEntity<Object> insertProduct(
			@RequestBody Map<String, java.math.BigDecimal[]> productIdArray, 
			@PathVariable("arg")java.math.BigDecimal userId ){
		return service.insertProduct(productIdArray, userId);
	}
	//ResponseEntity<Object> insertProduct(Map<String, java.math.BigDecimal[]> idArray, java.math.BigDecimal id )
	
}

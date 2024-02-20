package com.ximena.shoppingcart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ximena.shoppingcart.repos.WishlistRepository;
import com.ximena.shoppingcart.services.WishlistService;

@RestController
@RequestMapping("/Wishlist")
public class WishlistController {
	
	@Autowired
	private WishlistRepository repository;
	@Autowired
	private WishlistService service;
	
	
}

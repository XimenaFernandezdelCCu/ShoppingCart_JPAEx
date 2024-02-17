package com.ximena.shoppingcart.services;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;

import com.ximena.shoppingcart.repos.UsersRepository;

public class UserServiceImpl implements UserService {
	
	@Autowired
	private UsersRepository repository;

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
	

	
	

}

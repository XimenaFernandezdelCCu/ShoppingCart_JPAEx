package com.ximena.shoppingcart.services;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ximena.shoppingcart.repos.ProductsRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired 
	private ProductsRepository repository; 

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

}

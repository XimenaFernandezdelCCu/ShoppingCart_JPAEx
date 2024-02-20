/*package com.ximena.shoppingcart.generators;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import com.ximena.shoppingcart.repos.ProductsRepository;

public class CustomProductIdGenerator implements IdentifierGenerator {
	
	private ProductsRepository repository;

	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) {
		
		try {
			List<java.math.BigDecimal> existingIds = repository.findAllIds();
			BigDecimal maxId = Collections.max(existingIds);
			BigDecimal newId = maxId.add(BigDecimal.ONE);
			return newId;
		} catch (NoSuchElementException e) {
			return BigDecimal.ONE; 
		}
	}

}*/

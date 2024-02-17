package com.ximena.shoppingcart.generators;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ximena.shoppingcart.repos.UsersRepository;
import com.ximena.shoppingcart.services.UserService;

import jakarta.annotation.PostConstruct;

@Component
public class CustomUserIdGenerator implements IdentifierGenerator {
	
	//@Autowired
	//private UsersRepository repository;
	@Autowired
	private UserService service; 
	
	@Override
	public java.math.BigDecimal generate(SharedSessionContractImplementor session, Object object) {
		return service.generateID();
	}

}

package com.ximena.shoppingcart.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ximena.shoppingcart.entities.User;

@Service
public interface UserService {
	//
	public java.math.BigDecimal generateID();

	public List<User> getOneUser(String arg);

	public ResponseEntity<Object> insertNewUser(User user);

	public ResponseEntity<Object> editUser(Map<String, Object> changes, BigDecimal id);

	public ResponseEntity<Object> deleteUser(BigDecimal id);



	
}

package com.ximena.shoppingcart.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ximena.shoppingcart.entities.User;

public interface UsersRepository extends CrudRepository<User, Integer> {
	
	//@Query("SELECT * FROM User")
	//@Query(value = "SELECT * FROM USERS", nativeQuery = true)
	//List<User> findAllUser();
	
	List<User> findByName(String name);
	List<User> findByEmail(String email);
	List<String> findAllEmails();
	
	
	

}

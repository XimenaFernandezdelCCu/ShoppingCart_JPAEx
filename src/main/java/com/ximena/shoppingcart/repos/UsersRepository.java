package com.ximena.shoppingcart.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ximena.shoppingcart.entities.User;

public interface UsersRepository extends CrudRepository<User, Integer> {
	
	
	@Query(value = "SELECT email FROM users", nativeQuery = true)
	List<String> findAllEmail();
	
	List<User> findByName(String name);
	List<User> findByEmail(String email);	
	

}

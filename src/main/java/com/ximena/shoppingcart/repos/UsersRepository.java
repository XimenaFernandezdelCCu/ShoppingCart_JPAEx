package com.ximena.shoppingcart.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ximena.shoppingcart.entities.User;

@Repository
public interface UsersRepository extends CrudRepository<User, java.math.BigDecimal> {
	
	@Query("SELECT userId FROM User")
	List<java.math.BigDecimal> findAllIds();
	
	@Query(value = "SELECT email FROM users", nativeQuery = true)
	List<String> findAllEmail();
	
	List<User> findByName(String name);
	List<User> findByEmail(String email);	
	

}

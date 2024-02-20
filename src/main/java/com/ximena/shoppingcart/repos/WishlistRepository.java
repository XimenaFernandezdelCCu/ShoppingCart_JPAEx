package com.ximena.shoppingcart.repos;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ximena.shoppingcart.entities.User;
import com.ximena.shoppingcart.entities.Wishlist;

import jakarta.transaction.Transactional;

@Repository
public interface WishlistRepository extends CrudRepository<Wishlist, java.math.BigDecimal> {
	
	@Query("SELECT wishId FROM Wishlist")
	List<java.math.BigDecimal> findAllIds();
	
	List<Wishlist> findByUserId(User userId);
	
	
	


}

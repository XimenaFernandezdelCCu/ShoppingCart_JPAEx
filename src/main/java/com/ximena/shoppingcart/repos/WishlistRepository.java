package com.ximena.shoppingcart.repos;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ximena.shoppingcart.entities.User;
import com.ximena.shoppingcart.entities.Wishlist;


@Repository
public interface WishlistRepository extends CrudRepository<Wishlist, BigDecimal> {
	
	@Query("SELECT wishId FROM Wishlist")
	List<BigDecimal> findAllIds();
	
	List<Wishlist> findByUserId(User userId);
	
	
	


}

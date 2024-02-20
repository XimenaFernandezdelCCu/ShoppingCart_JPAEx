package com.ximena.shoppingcart.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ximena.shoppingcart.entities.Wishlist;

@Repository
public interface WishlistRepository extends CrudRepository<Wishlist, java.math.BigDecimal> {
	
	@Query("SELECT wishId FROM Wishlist")
	List<java.math.BigDecimal> findAllIds();

}

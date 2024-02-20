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
	
	@Modifying
	@Transactional
	@Query(value ="DELETE FROM wishlist WHERE USER_ID= :userId AND PRODUCT_ID= :productId; ",
			nativeQuery = true)
	void deleteByUserANDProduct(
			@Param("userId") BigDecimal userId, 
			@Param("productId") BigDecimal productId );
	
	@Modifying
	@Transactional
	@Query(value ="DELETE FROM wishlist WHERE USER_ID= 966 AND PRODUCT_ID= 2940; ",
			nativeQuery = true)
	void deleteByUserANDProduct2();
	


}

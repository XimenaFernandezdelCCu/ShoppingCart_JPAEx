package com.ximena.shoppingcart.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ximena.shoppingcart.entities.Order;
import com.ximena.shoppingcart.entities.User;

import java.math.BigDecimal;


@Repository
public interface OrdersRepository extends CrudRepository<Order, java.math.BigDecimal> {
	
	@Query("SELECT orderId FROM Order")
	List<java.math.BigDecimal> findAllIds();
	
	//List<Order> findByOrderId(BigDecimal orderId);
	List<Order> findByUser(User user);
	
	//@Query("FROM Order WHERE User = :userId")
	//List<Order> findByUserId(java.math.BigDecimal);
	@Query(value = "SELECT * FROM ORDER_HISTORY WHERE USER_ID = :userId", nativeQuery = true)
	List<Order> findOrderByUserId(@Param("userId") java.math.BigDecimal userId);

}

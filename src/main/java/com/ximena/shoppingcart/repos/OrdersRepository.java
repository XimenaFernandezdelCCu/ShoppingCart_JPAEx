package com.ximena.shoppingcart.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ximena.shoppingcart.entities.Orders;

public interface OrdersRepository extends CrudRepository<Orders, java.math.BigDecimal> {
	@Query("SELECT orderId FROM Orders")
	List<java.math.BigDecimal> findAllIds();

}

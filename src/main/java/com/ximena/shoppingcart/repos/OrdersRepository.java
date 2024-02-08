package com.ximena.shoppingcart.repos;

import org.springframework.data.repository.CrudRepository;

import com.ximena.shoppingcart.entities.Orders;

public interface OrdersRepository extends CrudRepository<Orders, Integer> {

}

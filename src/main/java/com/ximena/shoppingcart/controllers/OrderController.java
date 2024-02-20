package com.ximena.shoppingcart.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ximena.shoppingcart.entities.Order;
import com.ximena.shoppingcart.entities.Product;
import com.ximena.shoppingcart.entities.User;
import com.ximena.shoppingcart.repos.OrdersRepository;
import com.ximena.shoppingcart.services.OrderService;


@RestController
@RequestMapping("/orderHistory")
public class OrderController {
	
	@Autowired
	private OrdersRepository repository;
	
	@Autowired
	private OrderService service; 
	
	// ------------ gets all orders 
	@GetMapping("/all")
	public List<Order> getOrders(){
		return (List<Order>) repository.findAll();  
	}
	
	// ------------  finds one user by email or by name.
	@GetMapping("/{arg}")
	public Optional<Order> getOneOrder(@PathVariable("arg") java.math.BigDecimal arg) {
		return service.getOneOrder(arg);
	}
	
	@GetMapping("/{arg}/product")
	public Product getOrderProducts(@PathVariable("arg") java.math.BigDecimal arg) {
		return  service.getOrderProducts(arg);
	}
	

}

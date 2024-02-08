package com.ximena.shoppingcart.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ximena.shoppingcart.entities.Products;
import com.ximena.shoppingcart.repos.ProductsRepository;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	private ProductsRepository repository;
	
	//@Autowired
	ProductController(ProductsRepository repository){
		this.repository = repository;
	}
		
	@GetMapping("/all")
	public List<Products> getProducts(){
		return (List<Products>) repository.findAll();  
	}
	
	@GetMapping("/{param}")
	public List<Products> getProductbyName(@PathVariable("param") String param) {
		try {
			double price = Double.parseDouble(param);
			return repository.findByPrice(price);
		} catch(NumberFormatException e) {
			return repository.findByName(param);	
		}
				
	}
	
	
	

}

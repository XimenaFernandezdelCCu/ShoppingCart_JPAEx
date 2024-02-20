package com.ximena.shoppingcart.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ximena.shoppingcart.entities.Product;
import com.ximena.shoppingcart.services.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService service; 
		
	@GetMapping("/all")
	public List<Product> getProducts(){
		return service.getProducts();  
	}
	
	@GetMapping("/{param}")
	public List<Product> getProductbyName(@PathVariable("param") String param) {
		return service.getProductbyName(param);
				
	}
	
	@PostMapping("/save")
	public ResponseEntity<Object> insertNewProduct(@RequestBody Product product) {
		return service.insertNewProduct(product);
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<Object> editProduct(@RequestBody  Map<String, Object> changes, @PathVariable("id") java.math.BigDecimal id){
		 return service.editProduct(changes, id);
	}
	
	@PutMapping("/delete/{id}")
	public ResponseEntity<Object> virtualDelete(@PathVariable("id") java.math.BigDecimal id){
		return service.virtualDelete(id);
	}
	
	
	

}

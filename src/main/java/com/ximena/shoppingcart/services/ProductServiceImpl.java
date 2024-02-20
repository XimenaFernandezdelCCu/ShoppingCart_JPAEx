package com.ximena.shoppingcart.services;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ximena.shoppingcart.entities.Product;
import com.ximena.shoppingcart.repos.ProductsRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired 
	private ProductsRepository repository; 

	// ------------  Returns Id based on Existing Ids. 
	public java.math.BigDecimal generateID() {
		try {
			List<java.math.BigDecimal> existingIds = repository.findAllIds();
			BigDecimal maxId = Collections.max(existingIds);
			BigDecimal newId = maxId.add(BigDecimal.ONE);
			return newId;
		} catch (NoSuchElementException e) {
			return BigDecimal.ONE; 
		}
	}
	
	// ---- All Products
	public List<Product> getProducts(){
		return (List<Product>) repository.findAll();  
	}
		
	// --- Get a single product by name
	public List<Product> getProductbyName(String param) {
		try {
			double price = Double.parseDouble(param);
			return repository.findByPrice(price);
		} catch(NumberFormatException e) {
			return repository.findByName(param);	
		}
				
	}
	
	// ----- save a new product 
	public ResponseEntity<Object> insertNewProduct(Product product) {
			
		String newProductName = product.getName();
		List<Product> existingProducts = repository.findByName(newProductName);
				
		if(!existingProducts.isEmpty()) {
			Product oldProduct = existingProducts.get(0); 
			int inventory = oldProduct.getTotalProductsInventory() + 1;
		 	oldProduct.setTotalProductsInventory(inventory);
		 	repository.save(oldProduct);
		 	String message = "Product with name " + newProductName + " already exists. Inventory increased by 1.";
	        return ResponseEntity.status(HttpStatus.CONFLICT).body(message);
		}
		
		Product newProduct =  repository.save(product);
		return ResponseEntity.ok(newProduct);
	}
		
	// ----- Edit existing Product 
	public ResponseEntity<Object> editProduct(Map<String, Object> changes,  java.math.BigDecimal id){
		Optional<Product> optionalProduct = repository.findById(id);
		if (!optionalProduct.isPresent()) {
			String message = "Couldn't find User with ID: " + id + ". Please try with another id.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
		}	
		Product product = optionalProduct.get();
		product.setPrice((double) changes.get("price"));
		product.setImage((byte[]) changes.get("image"));
		product.setDescription((String) changes.get("description"));
		product.setTotalProductsInventory((int) changes.get("totalProductsInventory"));
        repository.save(product); 
        
        
        return ResponseEntity.ok(product); 
	}
		
	// --- Delete product by ID
	public ResponseEntity<Object> virtualDelete(java.math.BigDecimal id){
		
		Optional<Product> optionalProduct = repository.findById(id);
		if (!optionalProduct.isPresent()) {
			String message = "Couldn't find User with ID: " + id + ". Please try with another id.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
		}	
		Product product = optionalProduct.get();
		product.setStatus(false);
        repository.save(product); 
       
        return ResponseEntity.ok(product); 
	}
		

}

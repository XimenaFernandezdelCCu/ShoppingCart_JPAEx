package com.ximena.shoppingcart.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping("/save")
	public ResponseEntity<Object> insertNewProduct(@RequestBody Products product) {
		
		String newProductName = product.getName();
		List<Products> existingProducts = repository.findByName(newProductName);
				
		if(!existingProducts.isEmpty()) {
			Products oldProduct = existingProducts.get(0); 
			int inventory = oldProduct.getTotalProductsInventory() + 1;
		 	oldProduct.setTotalProductsInventory(inventory);
		 	repository.save(oldProduct);
		 	String message = "Product with name " + newProductName + " already exists. Inventory increased by 1.";
	        return ResponseEntity.status(HttpStatus.CONFLICT).body(message);
		}
		
		Products newProduct =  repository.save(product);
		return ResponseEntity.ok(newProduct);
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<Object> editProduct(@RequestBody  Map<String, Object> changes, @PathVariable("id") int id){
		Optional<Products> optionalProduct = repository.findById(id);
		if (!optionalProduct.isPresent()) {
			String message = "Couldn't find User with ID: " + id + ". Please try with another id.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
		}	
		Products product = optionalProduct.get();
		product.setPrice((double) changes.get("price"));
		product.setImage((byte[]) changes.get("image"));
		product.setDescription((String) changes.get("description"));
		product.setTotalProductsInventory((int) changes.get("totalProductsInventory"));
        repository.save(product); 
        
        
        return ResponseEntity.ok(product); 
	}
	
	@PutMapping("/delete/{id}")
	public ResponseEntity<Object> virtualDelete(@PathVariable("id") int id){
		
		Optional<Products> optionalProduct = repository.findById(id);
		if (!optionalProduct.isPresent()) {
			String message = "Couldn't find User with ID: " + id + ". Please try with another id.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
		}	
		Products product = optionalProduct.get();
		product.setStatus(false);
        repository.save(product); 
       
        return ResponseEntity.ok(product); 
	}
	
	
	

}

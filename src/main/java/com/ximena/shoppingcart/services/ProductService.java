package com.ximena.shoppingcart.services;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ximena.shoppingcart.entities.Product;

@Service
public interface ProductService {
	
	public java.math.BigDecimal generateID();
	
	public List<Product> getProducts();
	public List<Product> getProductbyName(String param);
	public ResponseEntity<Object> insertNewProduct(Product product);
	public ResponseEntity<Object> editProduct(Map<String, Object> changes, java.math.BigDecimal id);
	public ResponseEntity<Object> virtualDelete(java.math.BigDecimal id);

}

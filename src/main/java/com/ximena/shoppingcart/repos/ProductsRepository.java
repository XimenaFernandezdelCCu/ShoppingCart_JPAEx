package com.ximena.shoppingcart.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ximena.shoppingcart.entities.Products;

public interface ProductsRepository extends CrudRepository<Products, java.math.BigDecimal> {
	
	List<Products> findByName(String name);
	List<Products> findByPrice(double price);
	
	@Query(value = "SELECT name  FROM products", nativeQuery = true)
	List<String> findAllNames();
	
	@Query(value = "SELECT TOTAL_PRODUCTS_INVENTORY FROM PRODUCTS WHERE NAME = :name", nativeQuery = true)
	int getInventory(@Param("name") String name);
	
	@Query("SELECT productId FROM Products")
	List<java.math.BigDecimal> findAllIds();

}

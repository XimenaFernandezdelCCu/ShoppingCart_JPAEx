package com.ximena.shoppingcart.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ximena.shoppingcart.entities.Product;

@Repository
public interface ProductsRepository extends CrudRepository<Product, java.math.BigDecimal> {
	
	List<Product> findByName(String name);
	List<Product> findByPrice(double price);
	
	@Query(value = "SELECT name  FROM products", nativeQuery = true)
	List<String> findAllNames();
	
	@Query(value = "SELECT TOTAL_PRODUCTS_INVENTORY FROM PRODUCTS WHERE NAME = :name", nativeQuery = true)
	int getInventory(@Param("name") String name);
	
	@Query("SELECT productId FROM Product")
	List<java.math.BigDecimal> findAllIds();

}

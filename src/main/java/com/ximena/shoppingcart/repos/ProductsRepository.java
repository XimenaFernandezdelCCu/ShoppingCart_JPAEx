package com.ximena.shoppingcart.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.ximena.shoppingcart.entities.Products;

public interface ProductsRepository extends CrudRepository<Products, Integer> {
	
	List<Products> findByName(String name);
	

}

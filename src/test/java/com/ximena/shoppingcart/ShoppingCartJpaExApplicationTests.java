package com.ximena.shoppingcart;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.ximena.shoppingcart.entities.*;
import com.ximena.shoppingcart.repos.OrdersRepository;
import com.ximena.shoppingcart.repos.ProductsRepository;
import com.ximena.shoppingcart.repos.UsersRepository;

@SpringBootTest
class ShoppingCartJpaExApplicationTests {
	
	@Autowired
	UsersRepository usersRepo;
	@Autowired
	ProductsRepository productsRepo;
	@Autowired
	OrdersRepository ordersRepo;

	@Test
	void InsertNewUser() {
		User user = new User();
		user.setName("Xime");
		user.setLastName("Cu");
		user.setEmail("name@email.com");
		user.setBio("Bio");
		user.setAreaOfInterest("Books");
		
		usersRepo.save(user);
	}
	
	
	@Test
	void InsertNewProduct() throws IOException {
		
		Products product = new Products();
		
		product.setName("House of Leaves Book");
		product.setPrice(560);
		
		File file = new File("C:\\Users\\xfernandezdelcast\\Desktop\\houseofleaves.jpg");
		byte myImg[] = new byte[(int)file.length()];
		FileInputStream inputStream = new FileInputStream(file);
		inputStream.read(myImg);
		
		product.setImage(myImg);
		
		
		product.setDescription("Description");
		product.setTotalProductsInventory(3);
		product.setStatus(true);
		
		productsRepo.save(product);
		inputStream.close();
	}
	
	@Test
	void findAllUsers() {
		System.out.println("-------------------------"+usersRepo.findAll());
	}
	
	@Test
	void showME() {
		List<String> existingProducts = productsRepo.findAllNames();
		System.out.println("........."+existingProducts);
	}
	

	
	
	

}

package com.ximena.shoppingcart.controllers;


import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ximena.shoppingcart.entities.User;
import com.ximena.shoppingcart.repos.UsersRepository;
import com.ximena.shoppingcart.services.UserService;


@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UsersRepository repository;
	
	@Autowired
	private UserService service; 
	
	
	// ------------ gets all users 
	@GetMapping("/all")
	public List<User> getUsers(){
		return (List<User>) repository.findAll();  
	}
	
	// ------------  finds one user by email or by name.
	@GetMapping("/{arg}")
	public List<User> getOneUser(@PathVariable("arg") String arg) {
		return service.getOneUser(arg);
	}
	
	// ------------ saves a new user to DB with details provided in the request body 
	@PostMapping("/save")
	public ResponseEntity<Object> insertNewUser(@RequestBody User user) {
		return service.insertNewUser(user);
	}
	
	// ------------ Edits a user's (found by their id) email and area of interest. 
	@PutMapping("/edit/{id}")
	public ResponseEntity<Object> editUser(@RequestBody  Map<String, Object> changes, @PathVariable("id") java.math.BigDecimal id){
        return service.editUser(changes, id) ; 
	}
		
	// ------------ Deletes a user.
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable("id") java.math.BigDecimal id){
        return service.deleteUser(id); 
	}
	


}

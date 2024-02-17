package com.ximena.shoppingcart.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
	
	// gets all users 
	@GetMapping("/all")
	public List<User> getUsers(){
		return (List<User>) repository.findAll();  
	}
	
	//finds one user by email or by name.
	@GetMapping("/{arg}")
	//public List<User> getUser(@RequestParam("arg") String arg) {
	public List<User> getUser(@PathVariable("arg") String arg) {
		if (arg.contains("@")) {
			return repository.findByEmail(arg);
		} else {
			return repository.findByName(arg);
		}
		
	}
	
	// saves a new user to DB with details provided in the request body 
	@PostMapping("/save")
	public ResponseEntity<Object> insertNewUser(@RequestBody User user) {
		List<String> existingEmails = repository.findAllEmail();
		String newEmail = user.getEmail();
		
		for (String mail : existingEmails) {
			if (newEmail.equals(mail)) {
				String message = "User with email " + newEmail + " already exists.";
	            return ResponseEntity.status(HttpStatus.CONFLICT).body(message);
			}
		}
		
		User savedUser = repository.save(user);
	    return ResponseEntity.ok(savedUser);
	}
	
	// Edits a user's (found by their id) email and area of interest. 
	@PutMapping("/edit/{id}")
	public ResponseEntity<Object> editUser(@RequestBody  Map<String, Object> changes, @PathVariable("id") java.math.BigDecimal id){
		Optional<User> optionalUser = repository.findById(id);
		if (!optionalUser.isPresent()) {
			String message = "Couldn't find User with ID: " + id + ". Please try with another id.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
		}	
		User user = optionalUser.get();
		user.setEmail((String) changes.get("email"));
		user.setAreaOfInterest((String) changes.get("areaOfInterest"));
        repository.save(user); 
        
        return ResponseEntity.ok(user); 
	}
		
	// Deletes a user.
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable("id") java.math.BigDecimal id){
	
		Optional<User> optionalUser = repository.findById(id);
		if (!optionalUser.isPresent()) {
			String message = "Couldn't find User with ID: " + id + ". Please try with another id.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
		}	
		
		repository.deleteById(id);
        
        return ResponseEntity.ok(optionalUser.get()); 
	}
	


}

package com.ximena.shoppingcart.controllers;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ximena.shoppingcart.entities.User;
import com.ximena.shoppingcart.repos.UsersRepository;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private UsersRepository repository;
	
	//@Autowired
	UserController(UsersRepository repository){
		this.repository = repository;
	}
	
	@GetMapping("/all")
	public List<User> getUsers(){
		return (List<User>) repository.findAll();  
	}
	
	@GetMapping("/{arg}")
	//public List<User> getUser(@RequestParam("arg") String arg) {
	public List<User> getUser(@PathVariable("arg") String arg) {
		if (arg.contains("@")) {
			return repository.findByEmail(arg);
		} else {
			return repository.findByName(arg);
		}
		
	}
	
	@PostMapping("/save")
	public User saveUser(@RequestBody User user) {
		return repository.save(user); 
	}
	

}

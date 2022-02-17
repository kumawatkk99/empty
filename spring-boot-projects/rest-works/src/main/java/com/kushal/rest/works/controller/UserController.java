package com.kushal.rest.works.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kushal.rest.works.beans.User;
import com.kushal.rest.works.exception.UserNotFoundException;
import com.kushal.rest.works.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping("/")
	public String sayHello() {
		return "Service is up";
	}

	// GET http://localhost:9090/user
	@GetMapping("/user")
	public List<User> getUsers() {
		return service.getAllUser();
	}

	// GET http://localhost:9090/user/101
	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable("id") Integer id) throws UserNotFoundException {
		User retUser = service.getUserByIdAsObject(id);
		if(retUser==null) {
			throw new UserNotFoundException("Sorry User With " + id + " not found");
		}
		return retUser;
	}

	// POST http://localhost:9090/user
	/*
	 * @PostMapping("/user") public User saveUser(@RequestBody User user) { return
	 * service.saveUser(user); }
	 */
	// POST http://localhost:9090/user
	@PostMapping("/user")
	public ResponseEntity<?> saveUser(@RequestBody User user) {
		User returnedUser = service.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(returnedUser);
	}
	
	@DeleteMapping("/user/{id}")
	public void deleteUserById(@PathVariable("id") Integer id) {
		
	}
	

	// PUT ->update
	// DELETE -->delete
	// GET --> user by name
	
	// PUT -> update
		@PutMapping("/user")
		public ResponseEntity<?> updateUser(@RequestBody User user) throws UserNotFoundException{
			
			if(service.getUserById(user.getId()).isPresent()) {
				User updateUser = service.updateUser(user);
				return ResponseEntity.status(HttpStatus.OK).body(updateUser);
			} else {
				throw new UserNotFoundException("User Not Found to Update" + user.toString());
			}
		}
		// DELETE -> delete 
		@DeleteMapping("/user/{id}")
		public ResponseEntity<?> deleteUser(@PathVariable Integer id) throws UserNotFoundException{
			
			if(service.getUserById(id).isPresent()) {
				service.deleteUser(id); 
				return ResponseEntity.status(HttpStatus.OK).body("User Deleted " + id);
			} else {
				throw new UserNotFoundException("User Not Found to Delete -> " +id);
			}
		}
		
		
		
		// GET - get users by name 
		@GetMapping("/name/user/{name}")
		public List<User> getUsersByName(@PathVariable String name) {
			return service.getUserByName(name); 
		}
}

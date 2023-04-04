package com.lcwd.user.service.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.lcwd.user.service.entity.User;
import com.lcwd.user.service.services.UserServices;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserServices services;
	
	// create USer
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user){
		
		User user2 = services.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user2);
		
	}
	
	
	// get Single USer
	@GetMapping("/{userId}")
	public ResponseEntity<User> getSingleUser(@PathVariable String userId){
		User user = services.getUser(userId);
		// fatching user rating service 
		return ResponseEntity.ok(user);
	}
	
	// get all users
	@GetMapping
	public ResponseEntity<List<User>> getallUsers(){
		List<User> list = services.getAllUSer();
		return ResponseEntity.ok(list);
	}
}

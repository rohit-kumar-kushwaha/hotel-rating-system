package com.userService.controllers;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userService.constants.UserConstants;
import com.userService.entities.User;
import com.userService.service.UserService;

@RestController
@RequestMapping(value = UserConstants.USERS)
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	// create
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User saveUser = userService.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveUser);
	}
	
	// get single user
	@GetMapping(value = UserConstants.USERID)
	public ResponseEntity<User> getSingleUser(@PathVariable String userId) {
		User user = userService.getUser(userId);
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
	
	// get all user
	@GetMapping
	public ResponseEntity<List<User>> getAllUser() {
		List<User> allUser = userService.getAllUser();
		return ResponseEntity.status(HttpStatus.OK).body(allUser);
	}
	
	// Delete user
	@DeleteMapping(value = UserConstants.USERID)
	public ResponseEntity<?> deleteUser(@PathVariable String userId) {
		User user = userService.getUser(userId);
		if(user != null) {
			userService.deleteUser(userId);
			return ResponseEntity.status(HttpStatus.OK).body(null);
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
	// update user
	@PutMapping(value = UserConstants.USERID)
	public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable("userId") String userId) {
		User updatedUser = userService.updateUser(user, userId);
		return ResponseEntity.status(HttpStatus.OK).body(updatedUser);
	}
	

}

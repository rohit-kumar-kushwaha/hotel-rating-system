package com.userService.service;

import java.util.List;

import com.userService.entities.User;

public interface UserService {
	
//	create user
	User saveUser(User user);
	
//	get all user
	List<User> getAllUser();
	
//	get one user by Id
	User getUser(String userId);
	
//	delete user
	void deleteUser(String userId);
	
//	update user
	User updateUser(User user, String userId);
	

}

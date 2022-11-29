package com.userService.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userService.entities.User;
import com.userService.exceptions.ResourceNotFoundException;
import com.userService.repository.UserRepository;
import com.userService.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		String randomUserId = UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User getUser(String userId) {
		// TODO Auto-generated method stub
		return userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User not found."));
	}

	@Override
	public void deleteUser(String userId) {
		// TODO Auto-generated method stub
		userRepository.deleteById(userId);
			
	}

	@Override
	public User updateUser(User user, String userId) {
		// TODO Auto-generated method stub
		user.setUserId(userId);
		return userRepository.save(user);
	}

}

package com.mazebank.mazebank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mazebank.mazebank.entity.User;
import com.mazebank.mazebank.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public User getUser(int id) {
		return userRepository.getUser(id);
	}
	
	
	
}

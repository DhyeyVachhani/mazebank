package com.mazebank.mazebank.service;

import java.util.ArrayList;

import com.mazebank.mazebank.repository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mazebank.mazebank.entity.User;
import com.mazebank.mazebank.repository.UserRepository;


@Service("userDetailService")
@ComponentScan(basePackages = "com.test.project.security.model")
public class JwtUserDetailService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserJpaRepository userJpaRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			User user = userJpaRepository.findByUserName(username);
			if (user == null) {
				throw new UsernameNotFoundException("User not found with username: " + username);
			}
			return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getUserPassword(), new ArrayList<>());
		} catch (Exception e){
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}

}
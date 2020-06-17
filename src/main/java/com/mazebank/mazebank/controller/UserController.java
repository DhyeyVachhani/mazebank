package com.mazebank.mazebank.controller;

import com.mazebank.mazebank.exception.BadReqestException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mazebank.mazebank.entity.User;
import com.mazebank.mazebank.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class UserController {

	@Autowired
	private UserService userService;

	private final Logger logger = LogManager.getLogger(getClass());

	@GetMapping("/user")
	public ResponseEntity<List<User>> login() {
		try {
			return ResponseEntity.ok(userService.listUser());
		} catch (Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUser(@PathVariable("id") String id) {
		try {
			return ResponseEntity.ok(userService.getUserById(Integer.parseInt(id)));
		} catch (BadReqestException e){
			logger.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		} catch (Exception e){
			logger.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@PostMapping("/user")
	public User createUser(@RequestBody User user){
		return userService.createUser(user);
	}

	@PutMapping("/user")
	public User updateUser(@RequestBody User user){
		return userService.updateUser(user);
	}
}
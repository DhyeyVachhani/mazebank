package com.mazebank.mazebank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mazebank.mazebank.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
		
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "src/main/resources/static/login.html";
	}
}

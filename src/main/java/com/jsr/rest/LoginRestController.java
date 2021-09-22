package com.jsr.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsr.binding.LoginForm;
import com.jsr.service.UserService;

@RestController
public class LoginRestController {
	
	@Autowired
	private UserService service;
	
	@PostMapping("/login")
	public String loginForm(@RequestBody LoginForm loginForm) {
		String status = service.loginUser(loginForm);
		return status;
	}
	
}

package com.jsr.rest;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jsr.service.UserService;

@RestController
public class ForgotPwdRestController {
	
	private UserService userService;
	
	public ForgotPwdRestController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/forgotPassword/{email}")
	public String forgotPassword(@PathVariable String email) {
		String status = userService.forgotPassword(email);
		return status;
	}
}

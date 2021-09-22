package com.jsr.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsr.binding.UnlockAccountForm;
import com.jsr.service.UserService;

@RestController
public class UnlockAccRestController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/unlockAccount")
	public String unlockAccount(@RequestBody UnlockAccountForm unlockAccForm) {
		boolean unlockAccount = userService.unlockAccount(unlockAccForm);
		if(unlockAccount) {
			return "Unlock Account";
		}
		return "Failed to Unlock Account";
	}
}

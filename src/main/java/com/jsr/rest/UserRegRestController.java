package com.jsr.rest;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsr.binding.UserRegForm;
import com.jsr.service.UserService;

@RestController
public class UserRegRestController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/countries")
	public Map<Integer, String> getCountries(){
		return userService.findCountries();
	}
	
	@GetMapping("/states/{countryId}")
	public Map<Integer, String> getStates(@PathVariable  Integer countryId){
		return userService.findStates(countryId);
	}
	
	@GetMapping("/cities/{stateId}")
	public Map<Integer, String> getCities(@PathVariable Integer stateId) {
		return userService.findCities(stateId);
	}
	
	@GetMapping("/emailCheck/{email}")
	public String checkUniqueEmail(@PathVariable String email) {
		 boolean status = userService.checkUniqueEmail(email);
		 if(status) {
			 return "Unique Email";
		 }
		 return "Duplicate Email";
	}
	
	@PostMapping("/saveUser")
	public String saveUser(@RequestBody UserRegForm userRegForm) {
		boolean saveUser = userService.saveUser(userRegForm);
		if(saveUser) {
			return "Successfully Register";
		}
		return "Failed to Register";
	}	
	
}

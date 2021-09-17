package com.jsr.service;

import java.util.Map;

import com.jsr.binding.LoginForm;
import com.jsr.binding.UnlockAccountForm;
import com.jsr.binding.UserRegForm;

public interface UserService {
	
	//For Login Functionality
	public String LoginUser(LoginForm loginForm);
	
	//For User Registration Functionality
	public Map<Integer, String> findCountries();
	public Map<Integer, String> findStates(Integer countryId);
	public Map<Integer, String> findCities(Integer stateId);
	public boolean checkUniqueEmail(String email);
	public boolean saveUser(UserRegForm userRegForm);
	
	//For Un-Lock Account functionality
	public boolean checkTempPwdValid(String email, String tempPwd);
	public boolean unlockAccount(UnlockAccountForm unlockAccountForm);
	
	//For Forgot Password Functionality
	public String forgotPassword(String email);
	
	
	
	
	
	
	
	
	
	
	
	
}

package com.jsr.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsr.binding.LoginForm;
import com.jsr.binding.UnlockAccountForm;
import com.jsr.binding.UserRegForm;
import com.jsr.constant.AppConstant;
import com.jsr.entity.City;
import com.jsr.entity.Country;
import com.jsr.entity.State;
import com.jsr.entity.User;
import com.jsr.props.AppProps;
import com.jsr.repo.CityRepository;
import com.jsr.repo.CountryRepository;
import com.jsr.repo.StateRepository;
import com.jsr.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private CountryRepository countryRepo;
	
	@Autowired
	private StateRepository stateRepo;
	
	@Autowired
	private CityRepository cityRepo;
	
	@Autowired
	private AppProps props;
	
	@Override
	public String LoginUser(LoginForm loginForm) {
		Map<String, String> messages = props.getMessages();
		
		User userEntity = userRepo.findByEmailAndPassword(loginForm.getEmail(), loginForm.getPassword());
		if(userEntity != null) {
			String accountStatus = userEntity.getAccountStatus();
			
			if(accountStatus.equals(AppConstant.LOCKED_ACCOUNT)) {
				return messages.get(AppConstant.Acc_Locked);
			}else {
				return messages.get(AppConstant.LOGIN_SUCCESS);
			}
			
		}else {
			return messages.get(AppConstant.INVALID_CREDENTIAL);
		}
	}

	@Override
	public Map<Integer, String> findCountries() {
		
		List<Country> getCountries = countryRepo.findAll();
		Map<Integer, String> mapCountry = new HashMap<>();
		
		getCountries.forEach(country -> {
			mapCountry.put(country.getCountryId(), country.getCountryName());
		});
		
		return mapCountry;
	}

	@Override
	public Map<Integer, String> findStates(Integer countryId) {
		
		List<State> getStates = stateRepo.findByCountryId(countryId);
		Map<Integer, String> mapState = new HashMap<>();
		
		getStates.forEach(state -> {
			mapState.put(state.getStateId(), state.getStateName());
		});
		return mapState;
	}

	@Override
	public Map<Integer, String> findCities(Integer stateId) {
		
		List<City> getCities = cityRepo.findByStateId(stateId);
		Map<Integer, String> mapCity = new HashMap<>();
		
		getCities.forEach(city -> {
			mapCity.put(city.getCityId(), city.getCityName());
		});
		
		return null;
	}

	@Override
	public boolean checkUniqueEmail(String email) {
		
		User userObj = userRepo.findByEmail(email);
		if(userObj.getEmail() == null) {
			return true;
		}
		return false;
	}
 
	@Override
	public boolean saveUser(UserRegForm userRegForm) {
		userRegForm.setPassword(generateTempPwd());
		userRegForm.setAccountStatus(AppConstant.LOCKED_ACCOUNT);
		
		User userEntityObj = new User();
		BeanUtils.copyProperties(userRegForm, userEntityObj);
		User saveUserObj = userRepo.save(userEntityObj);
		
		if(saveUserObj.getUserId() != null) {
			// TODO create logic for sending email for unlock account
		}
			
		return false;
	}

	@Override
	public boolean unlockAccount(UnlockAccountForm unlockAccountForm) {
		
		User userEntity = userRepo.findByEmailAndPassword(unlockAccountForm.getEmail(), unlockAccountForm.getTempPassword());
		
		if(userEntity != null) {
			userEntity.setAccountStatus(AppConstant.UNLOCK_ACCOUNT);
			userEntity.setPassword(unlockAccountForm.getNewPassword());
			userRepo.save(userEntity);
			return true;
		}
		return false;
	}

	@Override
	public String forgotPassword(String email) {
		Map<String, String> messages = props.getMessages();
		
		User userObj = userRepo.findByEmail(email);
		
		if(userObj != null) {
			// TODO for sending email to user
			return messages.get(AppConstant.SUCCESS);
		}
		return messages.get(AppConstant.FAIL);
	}
	
	private String generateTempPwd() {
		String tempPassword = RandomStringUtils.randomAlphanumeric(6);
		return tempPassword;
	}
}

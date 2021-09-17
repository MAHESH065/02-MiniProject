package com.jsr.binding;

import java.util.Date;

import lombok.Data;

@Data
public class UserRegForm {
	
	private String firstName;
	private String lastName;
	private String email;
	private String phNo;
	private Date dob;
	private String gender;
	private String country;
	private String state;
	private String city;
	private String password;
	private String accountStatus;
	
}

package com.jsr.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity(name = "user_dtls")
public class User {
	
	@Id
	@GeneratedValue
	@Column(name = "user_id")
	private Integer userId;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	private String email;
	
	@Column(name = "ph_no")
	private String phNo;
	
	private Date dob;
	
	private String gender;
	
	private String country;
	
	private String state;
	
	private String city;
	
	private String password;
	
	@Column(name = "account_status")
	private String accountStatus;
	
	@Column(name = "created_date", updatable = false)
	@CreationTimestamp
	private LocalDate createdDate;
	
	@Column(name = "updated_date", insertable = false)
	@UpdateTimestamp
	private LocalDate updatedDate;
}

package com.jsr.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name = "country_dtls")
public class Country {
	
	@Id
	@GeneratedValue
	@Column(name = "country_id")
	private Integer countryId;
	
	@Column(name = "country_name")
	private String countryName;
}

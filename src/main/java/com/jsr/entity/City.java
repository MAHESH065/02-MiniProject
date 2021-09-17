package com.jsr.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name = "city_dtls")
public class City {
	
	@Id
	@GeneratedValue
	@Column(name = "city_id")
	private Integer cityId;
	
	@Column(name = "city_name")
	private String cityName;
	
	@Column(name = "state_id")
	private Integer stateId;

}

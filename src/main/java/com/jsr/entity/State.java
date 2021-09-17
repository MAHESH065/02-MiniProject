package com.jsr.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name = "state_dtls")
public class State {
	
	@Id
	@GeneratedValue
	@Column(name = "state_id")
	private Integer stateId;
	
	@Column(name = "state_name")
	private String stateName;
	
	@Column(name = "country_id")
	private Integer countryId;
}

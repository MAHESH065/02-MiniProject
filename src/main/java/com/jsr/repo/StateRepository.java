package com.jsr.repo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsr.entity.State;

public interface StateRepository extends JpaRepository<State, Serializable> {
	
	public List<State> findByCountryId(Integer countryId);
}

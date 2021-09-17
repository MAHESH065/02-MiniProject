package com.jsr.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsr.entity.Country;

public interface CountryRepository extends JpaRepository<Country, Serializable> {

}

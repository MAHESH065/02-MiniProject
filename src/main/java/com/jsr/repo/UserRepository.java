package com.jsr.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsr.entity.User;

public interface UserRepository extends JpaRepository<User, Serializable> {
	
	public User findByEmailAndPassword(String email, String password);
	
	public User findByEmail(String email);
}

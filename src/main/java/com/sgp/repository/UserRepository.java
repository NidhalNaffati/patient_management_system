package com.sgp.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.sgp.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	boolean existsByMatricule(Long matricule);
	boolean existsByEmail(String email);
	
	@Query("SELECT u FROM User u WHERE u.email = ?1")
	public User findByEmail(String email);
	public Page<User> findByEmailContains (String kw, Pageable pageable);
	 public User findByResetPasswordToken(String token);
	}



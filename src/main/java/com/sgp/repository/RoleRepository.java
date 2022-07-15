package com.sgp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.sgp.model.Role;
import com.sgp.model.User;

public interface RoleRepository extends JpaRepository<Role, Long> {
	@Query("SELECT u FROM User u WHERE u.email = ?1")
	public User findByEmail(String email);
	
	

    Role findByName(String name);
	
}

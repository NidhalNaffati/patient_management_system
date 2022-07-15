package com.sgp.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import com.sgp.model.Privilege;
import com.sgp.model.Role;

public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {

	public Page<Privilege> findByNameContains (String kw, Pageable pageable);

    Privilege findByName(String name);

    Privilege findPrivilegeByActionAndEntityAndRoles(String action, String entity, Role role);
}

package com.sgp.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.sgp.model.Irm;

@Repository
public interface IrmRepository  extends JpaRepository <Irm, Long> {
	

	
	
	@Query(value = "SELECT irm FROM  Irm irm  WHERE irm.id = ?1 ")
	List<Irm> findAllByIdIrm(Long id);
}
	


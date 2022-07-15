package com.sgp.repository;

import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sgp.model.EchoExamenClinique;
@Repository
public interface EchoExamenCliniqueRepository extends JpaRepository<EchoExamenClinique, Long> {
	
	public Page<EchoExamenClinique> findByechoCardiaque (String kw, Pageable pageable);


}

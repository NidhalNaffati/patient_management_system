package com.sgp.repository;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sgp.model.DossierMedical;



@Repository

public interface DossierMedicalRepository  extends JpaRepository <DossierMedical, Long> {
	
	
	public Page<DossierMedical> findBylactaleSgContains (String kw, Pageable pageable);
	
	

}

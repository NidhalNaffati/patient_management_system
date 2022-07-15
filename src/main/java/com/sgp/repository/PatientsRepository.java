package com.sgp.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sgp.model.Patient;
@Repository
public interface PatientsRepository extends JpaRepository <Patient, Long> {
	
	 Page<Patient> findByNomContains(String keyWord, Pageable pageable);
	
	

}

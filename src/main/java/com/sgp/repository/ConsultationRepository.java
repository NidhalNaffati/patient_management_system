package com.sgp.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sgp.model.Consultation;



public interface ConsultationRepository  extends JpaRepository<Consultation, Long> {
	
	 
	 
}

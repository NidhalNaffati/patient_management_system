package com.sgp.repository;



import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sgp.model.Medecin;

@Repository
public interface MedecinRepository extends JpaRepository <Medecin, Long> {


	public Page<Medecin> findByNomContains (String kw, Pageable pageable);
	
	List<Medecin> findByMatricule(Long matricule);
	
	/*
	 * List<Medecin> findByPatientsId(Integer id);
	 */	
}

package com.sgp.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sgp.model.Medecin;
import com.sgp.model.Secretaire;
@Repository
public interface SecretaireRepository  extends JpaRepository <Secretaire, Long> {
	public Page<Secretaire> findByNomContains (String kw, Pageable pageable);
	
	List<Secretaire> findByMatricule(Long matricule);

}

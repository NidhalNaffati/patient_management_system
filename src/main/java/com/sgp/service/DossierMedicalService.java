package com.sgp.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sgp.model.DossierMedical;






public interface DossierMedicalService {

	List<DossierMedical> listAllDossierMedical();

	DossierMedical saveDossierMedical(DossierMedical dossierMedical);

	DossierMedical getDossierMedicalById(Long numDossier);

	DossierMedical updateDossierMedical(DossierMedical dossierMedical);

	void deleteDossierMedicalById(Long numDossier);
	
	 Page<DossierMedical> findBylactaleSgContains (String kw, Pageable pageable);
	
}

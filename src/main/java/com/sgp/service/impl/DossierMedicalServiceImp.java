package com.sgp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sgp.model.DossierMedical;
import com.sgp.repository.DossierMedicalRepository;
import com.sgp.service.DossierMedicalService;


@Service
public class DossierMedicalServiceImp implements DossierMedicalService{
	@Autowired
	private DossierMedicalRepository dossierMedicalRepository;

	@Override
public List<DossierMedical> listAllDossierMedical() {
	return dossierMedicalRepository.findAll();
	
}
	@Override
public DossierMedical saveDossierMedical(DossierMedical dossierMedical) {
	return dossierMedicalRepository.save(dossierMedical);
}
	@Override
	public DossierMedical getDossierMedicalById(Long id) {
		DossierMedical 	dossierMedical = dossierMedicalRepository.findById(id).get();
		if(dossierMedical == null) throw new RuntimeException("compte dossierMedical introuvable");
		return dossierMedical ;
	};

	@Override
	public DossierMedical updateDossierMedical(DossierMedical dossierMedical) {
		return dossierMedicalRepository.save(dossierMedical);
	}

@Override
public void deleteDossierMedicalById(Long numDossier) {
	dossierMedicalRepository.deleteById(numDossier);
	
}
@Override
 public Page<DossierMedical> findBylactaleSgContains (String kw, Pageable pageable){
	 return dossierMedicalRepository.findBylactaleSgContains(kw, pageable);
 }
	}


	
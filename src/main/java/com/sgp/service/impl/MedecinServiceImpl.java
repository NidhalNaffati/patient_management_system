package com.sgp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgp.model.Medecin;
import com.sgp.repository.MedecinRepository;
import com.sgp.service.MedecinService;


@Service
public class MedecinServiceImpl implements MedecinService{
	@Autowired
	private MedecinRepository medecinRepository;
	
	public MedecinServiceImpl(MedecinRepository medecinRepository) {
		super();
		this.medecinRepository = medecinRepository;
	}

	@Override
public List<Medecin> listAllMedecin() {
	return medecinRepository.findAll();
	
}
	@Override
public  Medecin saveMedecin(Medecin medecin) {
	return medecinRepository.save(medecin);
}
	
	@Override
	public Medecin getMedecinById(Long id) {
		Medecin 	medecin = medecinRepository.findById(id).get();
		if(medecin == null) throw new RuntimeException("compte Medecin introuvable");
		return medecin ;
	};
	@Override
	public Medecin updateMedecin(Medecin medecin) {
		return medecinRepository.save(medecin);
	}

@Override
public void deleteMedecinById(Long matricule) {
	medecinRepository.deleteById(matricule);
	
}


 




	}


	
	
	
	
	


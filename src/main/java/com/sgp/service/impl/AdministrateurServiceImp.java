package com.sgp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgp.model.Administrateur;
import com.sgp.repository.AdministrateurRepository;
import com.sgp.service.AdministrateurService;



@Service
public class AdministrateurServiceImp implements AdministrateurService{
	@Autowired
	private AdministrateurRepository administrateurRepository;
	
	public AdministrateurServiceImp(AdministrateurRepository administrateurRepository) {
		super();
		this.administrateurRepository = administrateurRepository;
	}

	@Override
public List<Administrateur> listAllAdministrateur() {
	return administrateurRepository.findAll();
	
}
	@Override
public  Administrateur saveAdministrateur(Administrateur administrateur) {
	return administrateurRepository.save(administrateur);
}
	@Override
public Administrateur getAdministrateursById(Long id) {
 Administrateur 	administrateur = administrateurRepository.findById(id).get();
	if(administrateur == null) throw new RuntimeException("compte Administrateur introuvable");
	return administrateur ;
}
	@Override
	public Administrateur updateAdministrateur(Administrateur administrateur) {
		getAdministrateursById(administrateur.getId());
		return administrateurRepository.save(administrateur);
	}

@Override
public void deleteAdministrateurById(Long id) {
	getAdministrateursById(id);
	administrateurRepository.deleteById(id);
	
}
	}



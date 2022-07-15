package com.sgp.service;

import java.util.List;

import com.sgp.model.Secretaire;


public interface SecretaireService {
	

	
Secretaire saveSecretaire(Secretaire secretaire);
	
Secretaire getSecretaireById(Long secretaireId);
	
Secretaire updateSecretaire(Secretaire secretaire);
	
	void deleteSecretaireById(Long secretaireId);

	List<Secretaire> listAllSecretaire();

	

	
}

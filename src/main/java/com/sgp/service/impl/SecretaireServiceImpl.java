package com.sgp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgp.model.Secretaire;
import com.sgp.repository.SecretaireRepository;
import com.sgp.service.SecretaireService;

@Service
public class SecretaireServiceImpl implements SecretaireService {

	@Autowired
	private SecretaireRepository secretaireRepository;

	public SecretaireServiceImpl(SecretaireRepository secretaireRepository) {
		super();
		this.secretaireRepository = secretaireRepository;
	}

	@Override
	public List<Secretaire> listAllSecretaire() {
		return secretaireRepository.findAll();

	}

	@Override
	public Secretaire saveSecretaire(Secretaire secretaire) {
		return secretaireRepository.save(secretaire);
	}

	@Override
	public Secretaire getSecretaireById(Long id) {
		Secretaire 	secretaire= secretaireRepository.findById(id).get();
		if(secretaire == null) throw new RuntimeException("compte secretaire introuvable");
		return secretaire ;
	}

	@Override
	public Secretaire updateSecretaire(Secretaire secretaire) {
		return secretaireRepository.save(secretaire);
	}

/*	public void delete(long secretaireId) {
		secretaireRepository.deleteById(secretaireId);
	}  */

	@Override
	public void deleteSecretaireById(Long secretaireId) {
		secretaireRepository.deleteById(secretaireId);

	}
}

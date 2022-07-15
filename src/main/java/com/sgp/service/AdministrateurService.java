package com.sgp.service;

import java.util.List;

import com.sgp.model.Administrateur;




public interface AdministrateurService {

	List<Administrateur> listAllAdministrateur();

	Administrateur saveAdministrateur(Administrateur administrateur);

	Administrateur getAdministrateursById(Long id);

	Administrateur updateAdministrateur(Administrateur administrateur);

	void deleteAdministrateurById(Long id);

	


}

package com.sgp.service;

import java.util.List;

import com.sgp.model.EchoExamenClinique;



public interface EchoExamenCliniqueService {

	List<EchoExamenClinique> listAllEchoExamenClinique();

	EchoExamenClinique saveEchoExamenClinique(EchoExamenClinique echoExamenClinique);

	EchoExamenClinique getEchoExamenCliniqueById(Long id);

	EchoExamenClinique updateEchoExamenClinique(EchoExamenClinique echoExamenClinique);

	void deleteEchoExamenCliniqueById(Long id);
	
	
	
}

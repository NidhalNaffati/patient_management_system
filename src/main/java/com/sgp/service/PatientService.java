package com.sgp.service;

import java.util.List;


import com.sgp.model.Patient;





public interface PatientService {


	
	List<Patient> listAllPatient();

	Patient savePatient(Patient patient);

	Patient updatePatient(Patient model);

	void deletePatientById(Long dossierExterne);

	Object get(Long id);

	Patient save(Patient patient);

	
}

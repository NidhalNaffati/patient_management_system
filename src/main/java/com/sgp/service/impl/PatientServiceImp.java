package com.sgp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgp.model.Patient;
import com.sgp.repository.PatientsRepository;
import com.sgp.service.PatientService;


@Service
public class PatientServiceImp implements PatientService{
	@Autowired
	private PatientsRepository patientsRepository;
	
	public PatientServiceImp(PatientsRepository patientsRepository) {
		super();
		this.patientsRepository = patientsRepository;
	}

	@Override
public List<Patient> listAllPatient() {
	return patientsRepository.findAll();
	
}
	@Override
public  Patient savePatient(Patient patient) {
	return patientsRepository.save(patient);
}
	@Override
	public Patient get(Long id) {
		Patient 	patient = patientsRepository.findById(id).get();
		if(patient == null) throw new RuntimeException("compte Patients introuvable");
		return patient ;
}
	
	@Override
	public Patient updatePatient(Patient patient) {
		return patientsRepository.save(patient);
	}

@Override
public void deletePatientById(Long dossierExterne) {
	patientsRepository.deleteById(dossierExterne);
	
}

@Override
public Patient save(Patient patient) {
	return patientsRepository.save(patient);
}


}





	



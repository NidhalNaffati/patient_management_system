package com.sgp.service;


import java.util.List;

import com.sgp.model.Consultation;

public interface ConsultationService {

	List<Consultation> listAllConsultation();

	Consultation saveConsultation(Consultation consultation);

	Consultation getConsultationById(Long id);

	Consultation updateConsultation(Consultation consultation);

	void deletedateConsultationById(Long id);

	

	



}

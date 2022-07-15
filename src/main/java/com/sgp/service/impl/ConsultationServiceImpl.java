package com.sgp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgp.model.Consultation;
import com.sgp.repository.ConsultationRepository;
import com.sgp.service.ConsultationService;



@Service
public class ConsultationServiceImpl implements  ConsultationService {
	
	@Autowired
	private ConsultationRepository consultationRepository;
	
	public ConsultationServiceImpl(ConsultationRepository consultationRepository) {
		super();
		this.consultationRepository = consultationRepository;
	}

	@Override
public List<Consultation> listAllConsultation() {
	return consultationRepository.findAll();
	
}
	@Override
public  Consultation saveConsultation(Consultation consultation) {
	return consultationRepository.save(consultation);
}
	
	@Override
	public Consultation getConsultationById(Long id) {
		Consultation 	consultation = consultationRepository.findById(id).get();
		if(consultation == null) throw new RuntimeException("il n'ya pas de consultation dans ce date");
		return consultation ;
	};
	@Override
	public Consultation updateConsultation(Consultation consultation) {
		return consultationRepository.save(consultation);
	}

@Override
public void deletedateConsultationById(Long id) {
	consultationRepository.deleteById(id);
	
}


 




	}


	
	
	
	
	





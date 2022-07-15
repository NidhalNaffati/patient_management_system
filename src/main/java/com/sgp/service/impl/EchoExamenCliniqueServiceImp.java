package com.sgp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgp.model.EchoExamenClinique;
import com.sgp.repository.EchoExamenCliniqueRepository;
import com.sgp.service.EchoExamenCliniqueService;



	@Service
	public class EchoExamenCliniqueServiceImp  implements  EchoExamenCliniqueService   {
		@Autowired
		private EchoExamenCliniqueRepository echoExamenCliniqueRepository;
		
		public EchoExamenCliniqueServiceImp (EchoExamenCliniqueRepository echoExamenCliniqueRepository) {
			super();
			this.echoExamenCliniqueRepository = echoExamenCliniqueRepository;
		}

		@Override
	public List<EchoExamenClinique> listAllEchoExamenClinique() {
		return echoExamenCliniqueRepository.findAll();
	}
		@Override
	public  EchoExamenClinique saveEchoExamenClinique(EchoExamenClinique echoExamenClinique) {
		return echoExamenCliniqueRepository.save(echoExamenClinique);
	}
		
		@Override
		public EchoExamenClinique getEchoExamenCliniqueById(Long id) {
			EchoExamenClinique 	echoExamenClinique = echoExamenCliniqueRepository.findById(id).get();
			if(echoExamenClinique == null) throw new RuntimeException("pas d'echo");
			return echoExamenClinique ;
		}
		@Override
		public EchoExamenClinique updateEchoExamenClinique(EchoExamenClinique  echoExamenClinique ) {
			return echoExamenCliniqueRepository.save(echoExamenClinique );
		}

	@Override
	public void deleteEchoExamenCliniqueById(Long id) {
		echoExamenCliniqueRepository.deleteById(id);
		
	}

	
	}





		


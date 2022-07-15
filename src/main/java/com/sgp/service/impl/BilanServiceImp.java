package com.sgp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgp.model.Bilan;

import com.sgp.repository.BilanRepository;

import com.sgp.service.BilanService;



	@Service
	public class BilanServiceImp  implements BilanService{
		@Autowired
		private BilanRepository bilanRepository;
		
		public BilanServiceImp (BilanRepository bilanRepository) {
			super();
			this.bilanRepository = bilanRepository;
		}

		@Override
	public List<Bilan> listAllBilan() {
		return bilanRepository.findAll();
		
	}
		@Override
	public  Bilan saveBilan(Bilan bilan) {
		return bilanRepository.save(bilan);
	}
		
		@Override
		public Bilan getBilanById(Long id) {
			Bilan 	bilan = bilanRepository.findById(id).get();
			if(bilan == null) throw new RuntimeException("compte Medecin introuvable");
			return bilan ;
		}
		@Override
		public Bilan updateBilan(Bilan  bilan ) {
			return bilanRepository.save(bilan );
		}

	@Override
	public void deleteBilanById(Long id) {
		bilanRepository.deleteById(id);
		
	}

	
	}





		


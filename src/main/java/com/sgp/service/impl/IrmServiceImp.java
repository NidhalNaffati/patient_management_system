package com.sgp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgp.model.Irm;
import com.sgp.repository.IrmRepository;
import com.sgp.service.IrmService;



	@Service
	public class IrmServiceImp  implements IrmService{
		@Autowired
		private IrmRepository irmRepository;
		
		public IrmServiceImp (IrmRepository irmRepository) {
			super();
			this.irmRepository = irmRepository;
		}

		@Override
	public List<Irm> listAllIrm() {
		return irmRepository.findAll();
		
	}
		@Override
	public  Irm saveIrm(Irm irm) {
		return irmRepository.save(irm);
	}
		
		@Override
		public Irm getIrmById(Long id) {
			Irm 	irm = irmRepository.findById(id).get();
			if(irm == null) throw new RuntimeException("compte Medecin introuvable");
			return irm ;
		};
		@Override
		public Irm updateMedecin(Irm  irm ) {
			return irmRepository.save(irm );
		}

	@Override
	public void deleteIrmById(Long id) {
		irmRepository.deleteById(id);
		
	}




		}


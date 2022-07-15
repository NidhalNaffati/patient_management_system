package com.sgp.service;

import java.util.List;

import com.sgp.model.Bilan;

public interface BilanService {

	
	List<Bilan> listAllBilan();

	Bilan saveBilan(Bilan bilan);

	Bilan getBilanById(Long id);

	

	void deleteBilanById(Long id);

	

	Bilan updateBilan(Bilan bilan);
}

package com.sgp.service;

import java.util.List;

import com.sgp.model.Irm;

public interface IrmService {

	List<Irm> listAllIrm();

	Irm saveIrm(Irm irm);

	Irm getIrmById(Long id);

	Irm updateMedecin(Irm irm);

	void deleteIrmById(Long id);

}

package com.sgp.service;




import java.util.*;

import com.sgp.model.Medecin;







public interface MedecinService {
   
	List<Medecin> listAllMedecin();
	
	Medecin saveMedecin(Medecin medecin);

	Medecin getMedecinById(Long matricule);

	Medecin updateMedecin(Medecin medecin);

	void deleteMedecinById(Long id);





	

	

}




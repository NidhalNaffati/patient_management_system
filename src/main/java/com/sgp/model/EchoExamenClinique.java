package com.sgp.model;





import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EchoExamenClinique    {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	private String	 echoCardiaque;
	
	private String gazSang;

     private String fondOeil;
   
     private String  eRG;
  
     private String  pEA;
    
     private String emgVcn;
 	private String numDossier;

     private String  eEG;
   
	
}


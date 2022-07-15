package com.sgp.model;




import java.util.Date;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Consultation {
	
	@GeneratedValue
	@Id
	private Long id;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateConsultation; 
	private String observation;
	private String traitementPris;
	private String medecinTraitant;
	private String prescription;
	private String numDossier;

	private String patient_id; 
	@ManyToOne
	@JoinColumn(name="dossier_medical_id")
	private DossierMedical dossierMedical;

	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "patient_id") private Patient patient;
	 */
	
	


}


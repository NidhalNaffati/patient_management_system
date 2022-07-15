package com.sgp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToOne;


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
public class DossierMedical {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	private String numDossier;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateExamen;
	private String lactaleSg;
	private Long consansguinite;
	@Column(name = "poids")
	private Long poids;
    private  String  marqueSurLeVersant;
	@Column(name = "taille")
	private Long taille;
	private String priseEnCharge;
	private  String  reanimatiaux;
	private  String  perimetreCranien;

	private  String  cassureStaturaponderal;
	private  String  traitementPris;
	
	private  String  dysmorphieFaciale;

	private Long ageDebut;
	
	private  String  signesDebut;
	
	private  String  tableauClinique;
	private  String  evolutionClinique;

	
	private  String  evolutionPousse;
	@Column(nullable = false, length = 40)
	private  String  pousseeDeclanchePar;
	private  String  dernierExamen;


	@Column(name = "muscle")
	private Long muscle;
	@Column(name = "foie")
	private Long foie;
	

	@Column(nullable = false, length = 40)
	private  String  hyperpilosite;
	
	
	@Column(name = "pyruvate")
	private Long pyruvate;
	@Column(nullable = false, length = 40)
	private  String  lp;
	@Column(nullable = false, length = 40)
	private  String  ammoniemie;
	@Column(name = "acideGrasLibres")
	private Long acideGrasLibres;
	@Column(name = "glycemie")
	private Long glycemie;
	@Column(name = "cAA")
	private Long cAA;
	private  String  biopsieMusculaire;
	
	@Column(name = "cAO")
	private Long cAO;
	@Column(nullable = false, length = 40)
	private  String  consentement;
	@Column(nullable = false, length = 40)
	private  String  prelevementADN;
	private  String  autresATCDPersonels;
	@Column(nullable = false, length = 40)
	private  String  orientationGenerale;
	
	private  String casSimilaire;
	
	private  String  casDecesNeonatal;

	private Long autresATCDFamilliaux;
	@Column(name = "appDigestif")
	private Long appDigestif;
	@Column(nullable = false, length = 40)
	private  String  deficienceIntellectuelle;
	@Column(nullable = false, length = 40)
	private  String  peau;
	@Column(nullable = false, length = 40)
	private  String  endocrino;
	@Column(nullable = false, length = 40)
	private  String  approcheSyndromique;
	@Column(name = "systNerveux")
	private Long systNerveux;
	private String  grossesse;
	@Column(name = "rein")
	private Long rein;
	@Column(name = "oeil")
	private Long oeil;
	@Column(name = "oreille")
	private Long oreille;
	@Column(name = "coeur")
	private Long coeur;
	private Long accouchement;

	private  String  voie;
	
	private  String  sFA;

	private  String  incidentsNeonataux;
	


	private  String  sejourNeonat;

	private  String  poidNaissance;

	private  String  diagnosticPrenatal;

	
	
	private Long denvers;

	@OneToOne(mappedBy = "dossierMedical")
	 private Patient patient;
	
}

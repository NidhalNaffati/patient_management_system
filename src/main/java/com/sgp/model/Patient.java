package com.sgp.model;








import javax.persistence.*;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@DiscriminatorValue("PATIENT")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Patient extends Personne {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String dossierExterne;
	private String dossierInterne;
	private String regimeSociale;
	private Long numeroDePere;
	private Long numeroDeMere;
	private String prenomPere;
	private String prenomMere;
	private String adressePar;
	private String region;
	 @OneToOne(cascade = CascadeType.ALL)
	private DossierMedical dossierMedical;
		

	
	
	
	
     
	
	}

	

	



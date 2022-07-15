package com.sgp.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

  @Inheritance(strategy=InheritanceType.JOINED)
  
  @DiscriminatorColumn(name="TypePersonne",discriminatorType=DiscriminatorType.
  STRING)
 
public abstract class Personne implements Serializable{
	

	    
	private static final long serialVersionUID = 1L;
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	private String nom;

	private String prenom;
	private String nomJeuneFille;
	private String etatCivil;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateNaissance;



	private String sexe;
	

	private String lieuNaissance;

	private String regimeSociale;
	
	private Address address;

	
	 private Contact contact; 
	 
	  @CreationTimestamp private LocalDateTime createDate;
	  
	  @UpdateTimestamp private LocalDateTime updateDate;
	 

}
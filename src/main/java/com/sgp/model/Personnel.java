package com.sgp.model;




import java.util.Date;


import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@DiscriminatorValue("PERSONNEL")



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

  @Inheritance(strategy=InheritanceType.JOINED)
  
  @DiscriminatorColumn(name="TypePersonnel",discriminatorType=DiscriminatorType
  .STRING)
 
public   class Personnel extends Personne {

	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
       
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateRecrutement;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateFinContrat;
	private String grade;
	private String specialite;
	 @OneToOne(mappedBy="personnel")
	 private User user ;

}

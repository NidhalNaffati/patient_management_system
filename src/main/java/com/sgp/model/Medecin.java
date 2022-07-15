package com.sgp.model;


import java.util.List;

import javax.persistence.*;

import lombok.Getter;

import lombok.Setter;
import lombok.ToString;

@Entity
@DiscriminatorValue("MEDECIN")
@Getter
@Setter

@ToString
public class Medecin extends Personnel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long matricule;
	@OneToMany
	@JoinColumn(name = "matricule")
	private List<Patient> patients ;
	
   
}
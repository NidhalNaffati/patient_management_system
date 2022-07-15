package com.sgp.model;



import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


import lombok.Getter;

import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@Entity

@ToString
@DiscriminatorValue("SECRETAIRE")


public class Secretaire extends Personnel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long matricule;

	}
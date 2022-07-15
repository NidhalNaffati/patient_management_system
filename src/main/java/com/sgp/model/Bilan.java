package com.sgp.model;


import java.io.File;

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
public class Bilan   {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	private String typeBilan;
	private Long valeur;
	private File file;
	
	
	
	

}

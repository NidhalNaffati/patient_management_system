package com.sgp.model;

import javax.persistence.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;


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


public class Administrateur {

	@GeneratedValue

	@Id
	private Long id;
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;



	
}
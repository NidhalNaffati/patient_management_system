package com.sgp.model;


import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Embeddable
public class Address {

	
		private Long codePostale;
		
		private String region;
		
		private String city;
		
		private String pays;
		
		private String rue;

		
		
}

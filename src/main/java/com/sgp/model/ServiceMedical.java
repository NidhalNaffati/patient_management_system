package com.sgp.model;

import java.io.Serializable;



import javax.persistence.Column;
import javax.persistence.Embeddable;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable

public class ServiceMedical  implements Serializable {
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		@Column(name = "Specialite")
		private Long specialiteService;
		@Column(name = "chef_de_service")
		private String chefService;
		
	
	
	
}

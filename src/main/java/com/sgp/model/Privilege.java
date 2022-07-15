package com.sgp.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Privilege  implements Serializable{
 
 	/**
	 * 
	 */
	private static final long serialVersionUID = -5935470028676796539L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String action;
    private String entity;
    
    @ManyToMany(mappedBy = "privileges")
    @JsonIgnore

    private Collection<Role> roles;
    
    private Boolean constrained;

    public Privilege(final String name) {
        super();
        this.name = name;
    }

    
    public Boolean isConstrained() {
        return constrained;
    }

    public void setIsConstrained(Boolean isConstrained){
        constrained = isConstrained;
    }
}


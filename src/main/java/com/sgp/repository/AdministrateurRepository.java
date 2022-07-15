package com.sgp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgp.model.Administrateur;


public interface AdministrateurRepository  extends JpaRepository <Administrateur, Long> {

}

package com.sgp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sgp.model.Personne;
@Repository
public interface PersonneRepository extends JpaRepository <Personne , Long> {

}

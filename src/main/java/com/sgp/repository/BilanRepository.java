package com.sgp.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import com.sgp.model.Bilan;

public interface BilanRepository extends JpaRepository <Bilan, Long>{


}

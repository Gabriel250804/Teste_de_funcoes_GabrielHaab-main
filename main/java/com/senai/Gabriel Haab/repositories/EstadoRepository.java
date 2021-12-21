package com.senai.Haab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.Haab.domain.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {

} 

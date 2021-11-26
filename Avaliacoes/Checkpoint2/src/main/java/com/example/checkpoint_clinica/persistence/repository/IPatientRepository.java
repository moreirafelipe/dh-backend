package com.example.checkpoint_clinica.persistence.repository;

import com.example.checkpoint_clinica.persistence.entities.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Map;

public interface IPatientRepository extends JpaRepository<PatientEntity, Integer> {

}

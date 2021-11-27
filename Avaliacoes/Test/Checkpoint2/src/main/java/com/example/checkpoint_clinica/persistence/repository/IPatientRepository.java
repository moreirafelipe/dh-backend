package com.example.checkpoint_clinica.persistence.repository;

import com.example.checkpoint_clinica.persistence.entities.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

//Set JpaRepository queries provider
public interface IPatientRepository extends JpaRepository<PatientEntity, Integer> {

}

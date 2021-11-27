package com.example.checkpoint_clinica.persistence.repository;

import com.example.checkpoint_clinica.persistence.entities.DentistEntity;
import org.springframework.data.jpa.repository.JpaRepository;

//Set JpaRepository queries provider
public interface IDentistRepository extends JpaRepository<DentistEntity, Integer> {

}

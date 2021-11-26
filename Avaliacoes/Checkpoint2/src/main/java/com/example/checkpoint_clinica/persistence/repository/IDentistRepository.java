package com.example.checkpoint_clinica.persistence.repository;

import com.example.checkpoint_clinica.persistence.entities.DentistEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IDentistRepository extends JpaRepository<DentistEntity, Integer> {

}

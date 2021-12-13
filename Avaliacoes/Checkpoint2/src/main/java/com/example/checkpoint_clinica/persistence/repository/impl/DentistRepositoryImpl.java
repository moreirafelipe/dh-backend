package com.example.checkpoint_clinica.persistence.repository.impl;

import com.example.checkpoint_clinica.persistence.entities.DentistEntity;
import com.example.checkpoint_clinica.persistence.repository.IDentistRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public abstract class DentistRepositoryImpl implements IDentistRepository {

    @Query("select p from dentists p where p.nome = ?1")
    public abstract Optional<DentistEntity> findByName(String namePatient);

}

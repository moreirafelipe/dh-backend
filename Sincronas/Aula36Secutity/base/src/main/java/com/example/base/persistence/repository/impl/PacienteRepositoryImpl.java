package com.example.base.persistence.repository.impl;

import com.example.base.persistence.entities.PacienteEntity;
import com.example.base.persistence.repository.PacienteRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public abstract class PacienteRepositoryImpl implements PacienteRepository {

    @Query("select p from PacienteEntity p where p.nome = ?1")
    public abstract Optional<PacienteEntity> findByNome(String nome);
}

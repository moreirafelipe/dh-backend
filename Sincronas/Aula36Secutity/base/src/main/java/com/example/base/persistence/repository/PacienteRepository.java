package com.example.base.persistence.repository;

import com.example.base.persistence.entities.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface PacienteRepository extends JpaRepository<PacienteEntity, Integer> {

    Optional<PacienteEntity> findByNome(String nome);
}

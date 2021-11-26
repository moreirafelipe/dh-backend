package com.example.aula.repository;

import com.example.aula.entities.ProfessorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProfessorRepository extends JpaRepository<ProfessorEntity, Integer> {

    @Query("select")
    Optional<ProfessorEntity> buscarPorNome(String nomeProf, String curso, String q);

}

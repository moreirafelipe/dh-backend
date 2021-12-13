package com.example.base.persistence.repository;

import com.example.base.persistence.entities.EnderecoEntity;
import com.example.base.persistence.entities.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Integer> {

    @Query("select p.rua from EnderecoEntity p where p.rua = ?1")
    List<String> findAllRuas();
}

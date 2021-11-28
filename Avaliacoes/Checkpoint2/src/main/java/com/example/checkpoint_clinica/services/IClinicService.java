package com.example.checkpoint_clinica.services;

import com.example.checkpoint_clinica.persistence.entities.DentistEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

//Set Service interface for layer methods standards
public interface IClinicService<T> {
    ResponseEntity<String> saveAndFlush(T t);
    List<T> findAll();
    Optional<T> findById(Integer id);
    ResponseEntity deleteById(Integer id);
    T update(T t);
}

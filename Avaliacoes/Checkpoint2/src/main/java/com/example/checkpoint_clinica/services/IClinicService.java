package com.example.checkpoint_clinica.services;

import com.example.checkpoint_clinica.persistence.entities.AddressEntity;
import com.example.checkpoint_clinica.persistence.entities.DentistEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IClinicService<T> {
    T saveAndFlush(T t);
    List<T> findAll();
    Optional<T> findById(Integer id);
    ResponseEntity deleteById(Integer id);
    T update(T t);
}

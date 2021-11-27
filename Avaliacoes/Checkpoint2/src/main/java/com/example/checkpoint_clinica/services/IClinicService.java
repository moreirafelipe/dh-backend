package com.example.checkpoint_clinica.services;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IClinicService<T> {
    ResponseEntity<String> saveAndFlush(T t);
    List<T> findAll();
    Optional<T> findById(Integer id);
    ResponseEntity deleteById(Integer id);
    T update(T t);
}
package com.example.checkpoint_clinica.services.impl;

import com.example.checkpoint_clinica.persistence.entities.DentistEntity;
import com.example.checkpoint_clinica.persistence.repository.IDentistRepository;
import com.example.checkpoint_clinica.services.IClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

//Set API service layer
@Service
public class DentistServiceImpl implements IClinicService<DentistEntity> {

    //Set repository for persistence interface
    @Autowired
    private IDentistRepository dentistRepository;

    //Set POST service
    @Override
    public ResponseEntity<String> saveAndFlush(DentistEntity dentist) {
        dentistRepository.saveAndFlush(dentist);
        return ResponseEntity.ok("Dentist successfully registered");
    }

    //Set GET services
    @Override
    public List<DentistEntity> findAll() {
        return dentistRepository.findAll();
    }

    @Override
    public Optional<DentistEntity> findById(Integer id) {
        return dentistRepository.findById(id);
    }

    //Set DELETE services
    @Override
    public ResponseEntity deleteById(Integer id) {
        dentistRepository.deleteById(id);
        return ResponseEntity.ok("Dentist successfully deleted!");
    }

    //Set UPDATE
    @Override
    public DentistEntity update(DentistEntity dentist) {
        DentistEntity dentistMapped = dentistRepository.getById(dentist.getId());

        if(dentist.getName() != null) {
            dentistMapped.setName(dentist.getName());
        }
        if(dentist.getLastname()!= null) {
            dentistMapped.setLastname(dentist.getLastname());
        }
        if (dentist.getAdmissionDate() != null) {
            dentistMapped.setAdmissionDate(dentist.getAdmissionDate());
        }
        if (dentist.getEmail() != null) {
            dentistMapped.setEmail(dentist.getEmail());
        }
        if(dentist.getMajor() != null) {
            dentistMapped.setMajor(dentist.getMajor());
        }

        return dentistRepository.saveAndFlush(dentistMapped);
    }
}

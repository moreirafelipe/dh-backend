package com.example.checkpoint_clinica.services.impl;


import com.example.checkpoint_clinica.persistence.entities.DentistEntity;
import com.example.checkpoint_clinica.persistence.entities.PatientEntity;
import com.example.checkpoint_clinica.persistence.repository.IAddressRepository;
import com.example.checkpoint_clinica.persistence.repository.IPatientRepository;
import com.example.checkpoint_clinica.services.IClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Set API service layer
@Service
public class PatientServiceImpl implements IClinicService<PatientEntity> {

    //Set repositories for persistence interface
    @Autowired
    private final IPatientRepository patientRepository;

    @Autowired
    private final IAddressRepository addressRepository;

    public PatientServiceImpl(IPatientRepository patientRepository, IAddressRepository addressRepository) {
        this.patientRepository = patientRepository;
        this.addressRepository = addressRepository;
    }

    //Set POST service
    @Override
    public ResponseEntity<String> saveAndFlush(PatientEntity patientEntity) {
        addressRepository.saveAndFlush(patientEntity.getAddress());
        patientRepository.saveAndFlush(patientEntity);

        return ResponseEntity.ok("Patient successfully registered");
    }

    //Set GET services
    @Override
    public List<PatientEntity> findAll() {
        return patientRepository.findAll();
    }

    @Override
    public Optional<PatientEntity> findById(Integer id) {
        return patientRepository.findById(id);
    }

    //Set DELETE services
    @Override
    public ResponseEntity deleteById(Integer id) {
        patientRepository.deleteById(id);
        return ResponseEntity.ok("Dentist successfully deleted!");
    }

    //Set UPDATE service
    @Override
    public PatientEntity update(PatientEntity patient) {

        PatientEntity patientMapped = patientRepository.getById(patient.getId());

        if (patient.getName() != null) {
            patientMapped.setName(patient.getName());
        }
        if (patient.getLastname() != null) {
            patientMapped.setLastname(patient.getLastname());
        }
        if (patient.getRegisteringDate() != null) {
            patientMapped.setRegisteringDate(patient.getRegisteringDate());
        }
        if (patient.getEmail() != null) {
            patientMapped.setEmail(patient.getEmail());
        }
        if (patient.getAddress().getState() != null) {
            patientMapped.getAddress().setState(patient.getAddress().getState());
        }
        if (patient.getAddress().getCity() != null) {
            patientMapped.getAddress().setCity(patient.getAddress().getCity());
        }
        if (patient.getAddress().getNeighborhood() != null) {
            patientMapped.getAddress().setNeighborhood(patient.getAddress().getNeighborhood());
        }
        if (patient.getAddress().getStreet() != null) {
            patientMapped.getAddress().setStreet(patient.getAddress().getStreet());
        }

        return patientRepository.saveAndFlush(patientMapped);
    }
}

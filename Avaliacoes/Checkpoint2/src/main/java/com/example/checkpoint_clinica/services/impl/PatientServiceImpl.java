package com.example.checkpoint_clinica.services.impl;


import com.example.checkpoint_clinica.persistence.entities.PatientEntity;
import com.example.checkpoint_clinica.persistence.repository.IAddressRepository;
import com.example.checkpoint_clinica.persistence.repository.IPatientRepository;
import com.example.checkpoint_clinica.services.IClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements IClinicService<PatientEntity> {

    @Autowired
    private final IPatientRepository patientRepository;

    @Autowired
    private final IAddressRepository addressRepository;

    public PatientServiceImpl(IPatientRepository patientRepository, IAddressRepository addressRepository) {
        this.patientRepository = patientRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public PatientEntity saveAndFlush(PatientEntity patientEntity) {
        addressRepository.saveAndFlush(patientEntity.getAddress());
        return patientRepository.saveAndFlush(patientEntity);
    }

    @Override
    public List<PatientEntity> findAll() {
        return patientRepository.findAll();
    }

    @Override
    public Optional<PatientEntity> findById(Integer id) {
        return Optional.of(patientRepository.findById(id).get());
    }

    @Override
    public ResponseEntity deleteById(Integer id) {
        patientRepository.deleteById(id);
        return ResponseEntity.ok("Dentist successfully deleted!");
    }

    @Override
    public PatientEntity update(PatientEntity patient) {

        PatientEntity patientMapped = patientRepository.getById(patient.getId());

        if (patient.getName() != null) {
            patientMapped.setName(patient.getName());
        }

        if (patient.getLastname() != null) {
            patientMapped.setLastname(patient.getLastname());
        }


        if (patient.getAddress().getState() != null) {
            patientMapped.getAddress().setState(patient.getAddress().getState());
        }

        if (patient.getAddress().getCity() != null) {
            patientMapped.getAddress().setCity(patient.getAddress().getCity());
        }

        if (patient.getAddress().getCity() != null) {
            patientMapped.getAddress().setCity(patient.getAddress().getCity());
        }

        return patientRepository.saveAndFlush(patientMapped);
    }
}

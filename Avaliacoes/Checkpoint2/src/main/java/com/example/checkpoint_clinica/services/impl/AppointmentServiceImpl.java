package com.example.checkpoint_clinica.services.impl;

import com.example.checkpoint_clinica.persistence.entities.AppointmentEntity;
import com.example.checkpoint_clinica.persistence.entities.DentistEntity;
import com.example.checkpoint_clinica.persistence.entities.PatientEntity;
import com.example.checkpoint_clinica.persistence.repository.IAppointmentRepository;
import com.example.checkpoint_clinica.persistence.repository.IDentistRepository;
import com.example.checkpoint_clinica.persistence.repository.IPatientRepository;
import com.example.checkpoint_clinica.services.IClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements IClinicService<AppointmentEntity> {

    //Set repository for persistence interface
    @Autowired
    private IAppointmentRepository appointmentRepository;

    @Autowired
    private IPatientRepository patientRepository;

    @Autowired
    private IDentistRepository dentistRepository;

    //Set POST service
    @Override
    public ResponseEntity<String> saveAndFlush(AppointmentEntity appointment) {

        appointment.setPatient(appointment.getPatient());
        appointment.setDentist(appointment.getDentist());

        appointmentRepository.saveAndFlush(appointment);
        return ResponseEntity.ok("Appointment successfully registered");
    }

    //Set GET services
    @Override
    public List<AppointmentEntity> findAll() {
        return appointmentRepository.findAll();
    }

    @Override
    public Optional<AppointmentEntity> findById(Integer id) {
        return appointmentRepository.findById(id);
    }

    @Override
    public ResponseEntity deleteById(Integer id) {
        appointmentRepository.deleteById(id);
        return ResponseEntity.ok("Appointment successfully deleted!");
    }

    @Override
    public AppointmentEntity update(AppointmentEntity appointment) {
        appointment.setPatient(appointment.getPatient());
        appointment.setDentist(appointment.getDentist());

        return appointmentRepository.saveAndFlush(appointment);
    }
}

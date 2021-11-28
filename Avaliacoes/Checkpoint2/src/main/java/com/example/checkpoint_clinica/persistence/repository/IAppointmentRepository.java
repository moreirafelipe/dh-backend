package com.example.checkpoint_clinica.persistence.repository;

import com.example.checkpoint_clinica.persistence.entities.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppointmentRepository extends JpaRepository<AppointmentEntity, Integer> {
}

package com.example.checkpoint_clinica.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name="appointments")
public class AppointmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer appointment_id;

    //Include patient entity to appointment
    @NotNull(message = "You must choose a patiend informing his/her ID in Integer format to make an appointment.")
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH) //Checar com Bellini - Manter DETACH -> mostrar artigo alura -> favoritos a30
    @JoinColumn(name = "patient_id")
    private PatientEntity patient;

    //Include dentist entity to appointment
    @NotNull(message = "You must choose a patiend by his/her ID in Integer format to make an appointment.")
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH) //Checar com Bellini - Manter DETACH -> mostrar artigo alura -> favoritos a30
    @JoinColumn(name = "dentist_id")
    private DentistEntity dentist;

    //Include appointment date and time schedulling
    @NotNull(message = "The appointemt date/time data is required in the pattern: yyyy-mm-ddThh:mm:ss.511Z")
    @FutureOrPresent(message = "The appointemt date/time must be in the current time or after.")
    private Date dateTime;
}

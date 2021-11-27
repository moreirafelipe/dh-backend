package com.example.checkpoint_clinica.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name="dentists")
public class DentistEntity {

    @Id
    @SequenceGenerator(name = "dentists_sequence", sequenceName = "dentists_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dentists_sequence")
    @Column(name="id")
    private Integer id;

    @NotEmpty(message="The fild name is required")
    @Column(name="name")
    private String name;

    @NotEmpty(message="The fild lastname is required")
    @Column(name="lastname")
    private String lastname;

    @NotNull(message = "The adminission date is required.")
    @FutureOrPresent(message = "The adminission date must be today or in the future.")
    private Date admissionDate;

    @NotEmpty(message="The fild email is required")
    @Email(message="Email field filled incorrectly. Please, follow the model: name@email.com")
    @Column(name="email")
    private String email;

    @NotEmpty(message="The fild major is required")
    @Column(name="major")
    private String major;
//
//    @OneToMany(mappedBy = "dentist", fetch = FetchType.LAZY)
//    private Set<PatientEntity> patients = new HashSet<>();

}

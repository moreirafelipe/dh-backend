package com.example.checkpoint_clinica.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name="patients")
public class PatientEntity {

    @Id
    @SequenceGenerator(name = "patients_sequence", sequenceName = "patients_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patients_sequence")
    @Column(name="id")
    private Integer id;

    @NotEmpty(message="The fild name is required")
    @Column(name="name")
    private String name;

    @NotEmpty(message="The fild lastname is required")
    @Column(name="lastname")
    private String lastname;

    @NotNull(message = "The entrance date is required.")
    @FutureOrPresent(message = "The entrance date must be today or in the future.")
    private Date registeringDate;

    @NotEmpty(message="The fild email is required")
    @Email(message="Email field filled incorrectly. Please, follow the model: name@email.com")
    @Column(name="email")
    private String email;

    @NotNull(message = "The address date is required.")
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "address_id")
    private AddressEntity address;

}

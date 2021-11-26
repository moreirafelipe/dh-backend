package com.example.checkpoint_clinica.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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

    @Column(name="name")
    private String name;

    @Column(name="lastname")
    private String lastname;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "address_id")
    private AddressEntity address;
}

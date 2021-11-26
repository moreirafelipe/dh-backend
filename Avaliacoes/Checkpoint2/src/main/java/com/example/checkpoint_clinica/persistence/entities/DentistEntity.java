package com.example.checkpoint_clinica.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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

    @Column(name="name")
    private String name;

    @Column(name="lastname")
    private String lastname;

    @Column(name="major")
    private String major;
//
//    @OneToMany(mappedBy = "dentist", fetch = FetchType.LAZY)
//    private Set<PatientEntity> patients = new HashSet<>();

}

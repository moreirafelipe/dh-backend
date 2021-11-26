package com.example.checkpoint_clinica.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="adresses")
public class AddressEntity {

    @Id
    @SequenceGenerator(name = "addresses_sequence", sequenceName = "addresses_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "addresses_sequence")
    @Column(name="id")
    private Integer id;

    @Column(name="state")
    private String state;

    @Column(name="city")
    private String city;

    @Column(name="neighborhood")
    private String neighborhood;

    @Column(name="street")
    private String street;
}

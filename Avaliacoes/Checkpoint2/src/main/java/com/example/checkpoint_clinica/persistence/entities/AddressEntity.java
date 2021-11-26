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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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

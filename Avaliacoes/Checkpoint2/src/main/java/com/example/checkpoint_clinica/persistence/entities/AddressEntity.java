package com.example.checkpoint_clinica.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

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

    @NotEmpty(message="The state field is required")
    @Column(name="state")
    private String state;

    @NotEmpty(message="The city field is required")
    @Column(name="city")
    private String city;

    @NotEmpty(message="The neighborhood field is required")
    @Column(name="neighborhood")
    private String neighborhood;

    @NotEmpty(message="The street field is required")
    @Column(name="street")
    private String street;
}

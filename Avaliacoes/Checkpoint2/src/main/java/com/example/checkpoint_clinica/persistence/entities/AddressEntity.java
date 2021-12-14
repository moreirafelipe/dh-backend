package com.example.checkpoint_clinica.persistence.entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Table(name="adresses")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    //Set @ControllerAdvice filds validations messages
    @NotEmpty(message="The state field is required")
    @Size(min = 2, max = 50, message = "The state field must be in String format and its length of must be between 2 and 100 characters.")
    @Column(name="state")
    private String state;

    @NotEmpty(message="The city field is required")
    @Size(min = 2, max = 50, message = "The city field must be in String format and its length must be between 2 and 100 characters.")
    @Column(name="city")
    private String city;

    @NotEmpty(message="The neighborhood field is required")
    @Size(min = 5, max = 50, message = "The neighborhood field must be in String format and its length of neighborhood must be between 5 and 100 characters.")
    @Column(name="neighborhood")
    private String neighborhood;

    @NotEmpty(message="The street field is required")
    @Size(min = 2, max = 50, message = "The street field must be in String format and its length of street must be between 2 and 100 characters.")
    @Column(name="street")
    private String street;
}

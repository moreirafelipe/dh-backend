package com.example.checkpoint_clinica.persistence.entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;


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

    //Set @ControllerAdvice filds validations messages
    @NotEmpty(message="The fild name is required")
    @Size(min = 2, max = 50, message = "The length of name must be between 2 and 50 characters.")
    @Column(name="name")
    private String name;

    @NotEmpty(message="The fild lastname is required")
    @Size(min = 2, max = 100, message = "The length of lastname must be between 2 and 100 characters.")
    @Column(name="lastname")
    private String lastname;

    @NotNull(message = "The entrance date is required.")
    @PastOrPresent(message = "The entrance date/time must be before the current time.")
    private Date registeringDate;

    @NotEmpty(message="The fild email is required")
    @Email(message="Email field filled incorrectly. Please, follow the model: name@email.com", flags = { Pattern.Flag.CASE_INSENSITIVE })
    @Column(name="email")
    private String email;

    @NotNull(message = "The address data is required.")
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "address_id")
    private AddressEntity address;
}

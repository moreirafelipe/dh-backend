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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    //Set @ControllerAdvice filds validations messages
    @NotEmpty(message="The field name is required")
    @Size(min = 2, max = 50, message = "The name field must be in String format and its length must be between 2 and 50 characters.")
    @Column(name="name")
    private String name;

    @NotEmpty(message="The field lastname is required")
    @Size(min = 2, max = 100, message = "The lastname field must be in String format and its length must be between 2 and 100 characters.")
    @Column(name="lastname")
    private String lastname;

    @NotNull(message = "The field registering date/time is required.")
    @PastOrPresent(message = "The name field registeringDate must be in String format and its entrance date/time must be before the current time.")
    private Date registeringDate;

    @NotEmpty(message="The field email is required")
    @Email(message="Email field filled incorrectly. Please, follow the model: name@email.com in String format", flags = { Pattern.Flag.CASE_INSENSITIVE })
    @Column(name="email")
    private String email;

    @NotNull(message = "The address data is required.")
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "address_id")
    private AddressEntity address;
}

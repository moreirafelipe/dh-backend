package com.example.checkpoint_clinica.persistence.entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

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

    //Set @ControllerAdvice filds validations messages
    @NotEmpty(message="The fild name is required")
    @Size(min = 2, max = 50, message = "The length of name must be between 2 and 50 characters.")
    @Column(name="name")
    private String name;

    @NotEmpty(message="The fild lastname is required")
    @Size(min = 2, max = 100, message = "The length of lastname must be between 2 and 100 characters.")
    @Column(name="lastname")
    private String lastname;

    @NotNull(message = "The adminission date is required in the pattern: yyyy-mm-ddThh:mm:ss.511Z")
    @PastOrPresent(message = "The adminission date/time must be before the current time.")
    private Date admissionDate;

    @NotEmpty(message="The fild email is required")
    @Email(message="Email field filled incorrectly. Please, follow the model: name@email.com", flags = { Pattern.Flag.CASE_INSENSITIVE })
    @Column(name="email")
    private String email;

    @NotEmpty(message="The fild major is required")
    @Size(min = 2, max = 50, message = "The length of major must be between 2 and 50 characters.")
    @Column(name="major")
    private String major;
}

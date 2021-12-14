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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    //Set @ControllerAdvice fields validations messages
    @NotEmpty(message="The field name is required")
    @Size(min = 2, max = 50, message = "The field name must be in String format and its length must be between 2 and 50 characters.")
    @Column(name="name")
    private String name;

    @NotEmpty(message="The field lastname is required")
    @Size(min = 2, max = 100, message = "The field lastname must be in String format and its length must be between 2 and 100 characters.")
    @Column(name="lastname")
    private String lastname;

    @NotNull(message = "The adminission date is required in the pattern: yyyy-mm-ddThh:mm:ss.511Z")
    @PastOrPresent(message = "The field name must be in String format and its adminission date/time must be before the current time.")
    private Date admissionDate;

    @NotEmpty(message="The field email is required")
    @Email(message="Email field filled incorrectly. Please, follow the model: name@email.com in String format", flags = { Pattern.Flag.CASE_INSENSITIVE })
    @Column(name="email")
    private String email;

    @NotEmpty(message="The field major is required")
    @Size(min = 2, max = 50, message = "The field major must be in String format and its length of major must be between 2 and 50 characters.")
    @Column(name="major")
    private String major;
}

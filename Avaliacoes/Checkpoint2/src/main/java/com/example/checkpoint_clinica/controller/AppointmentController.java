package com.example.checkpoint_clinica.controller;

import com.example.checkpoint_clinica.exceptionhandler.IllegalDataException;
import com.example.checkpoint_clinica.persistence.entities.AppointmentEntity;
import com.example.checkpoint_clinica.persistence.entities.DentistEntity;
import com.example.checkpoint_clinica.persistence.entities.PatientEntity;
import com.example.checkpoint_clinica.services.impl.AppointmentServiceImpl;
import com.example.checkpoint_clinica.services.impl.DentistServiceImpl;
import com.example.checkpoint_clinica.services.impl.PatientServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

//Mapping paths
@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private static final Logger logger = LogManager.getLogger(AppointmentController.class);

    @Autowired
    private AppointmentServiceImpl appointmentService;

    @Autowired
    private PatientServiceImpl patientService;

    @Autowired
    private DentistServiceImpl dentistService;

    //Setting POST
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity saveAndFlush(@Valid @RequestBody AppointmentEntity appointment) {

        Optional<PatientEntity> patientEntity = patientService.findById(appointment.getPatient().getId());
        Optional<DentistEntity> dentistEntity = dentistService.findById(appointment.getDentist().getId());

        if(patientEntity.isEmpty()){
            logger.error("Couldn't register a new appointment because there's no patient registered with this ID");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Couldn't register because there's no patient registered with this ID");

        } else if(dentistEntity.isEmpty()){
            logger.error("Couldn't register a new appointment because there's no dentist registered with this ID");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Couldn't register because there's no dentist registered with this ID");
        }

        logger.info("Appointment registered successfully!");
        return ResponseEntity.ok(appointmentService.saveAndFlush(appointment));
    }

    //Setting GET
    @GetMapping("/list")
    public ResponseEntity findAll() {

        //Setting 404 return
        List<AppointmentEntity> appointmentEntities = appointmentService.findAll();
        if(appointmentEntities.isEmpty()){
            logger.error("There aren't appointments registered");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("There aren't appointments registered");
        }

        //Setting 200 Return
        logger.info("Registers recovered successfully!");
        return ResponseEntity.ok(appointmentEntities);
    }

    @GetMapping("/list/{id}")
    public ResponseEntity findById(@PathVariable Integer id) {
        Optional<AppointmentEntity> appointmentEntity = appointmentService.findById(id);

        //Setting 404 return
        if(appointmentEntity.isEmpty()){
            logger.error("There there's no appointment registered with this ID");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("There there's no appointment registered with this ID");
        }

        //Setting 200 Return
        logger.info("Register recovered successfully!");
        return ResponseEntity.ok(appointmentEntity);
    }

    //Setting UPDATE
    @PutMapping("/update")
    public ResponseEntity update (@RequestBody AppointmentEntity appointment){
        Optional<AppointmentEntity> appointmentEntity = appointmentService.findById(appointment.getAppointment_id());
        Optional<PatientEntity> patientEntity = Optional.ofNullable(appointment.getPatient());
        Optional<DentistEntity> dentistEntity = Optional.ofNullable(appointment.getDentist());

        //Setting 404 returns
        if(appointmentEntity.isEmpty()){
            logger.error("Couldn't update the appointment because there's no appointment registered with this ID");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Couldn't update the appointment because there's no appointment registered with this ID");

        } else if(patientEntity.isEmpty()){
            logger.error("Couldn't update the appointment because there's no patient registered with this ID");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Couldn't update the appointment because there's no patient registered with this ID");

        } else if(dentistEntity.isEmpty()){
            logger.error("Couldn't update the appointment because there's no dentist registered with this ID");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Couldn't update the appointment because there's no dentist registered with this ID");
        }

        try {
            //Setting 200 Return
            ResponseEntity response = ResponseEntity.ok(appointmentService.update(appointment));
            logger.info("Appointment updated successfully!");
            return response;
        } catch (IllegalDataException ex) {
            logger.error("Incorrect object! This endpoint only accepts JSON objects!");
            throw new IllegalDataException("Incorrect object! This endpoint only accepts JSON objects!");

        } catch (Exception ex) {
            logger.error("Incorrect data informed. Please, check the exception message and try again!");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    //Setting DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){
        Optional<AppointmentEntity> appointmentEntity = appointmentService.findById(id);

        //Setting 404 return
        if(appointmentEntity.isEmpty()) {
            logger.error("Couldn't delete because there's no appointment registered with this ID");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Couldn't delete because there's no appointment registered with this ID");
        }

        appointmentService.deleteById(id);

        //Setting 200 Return
        logger.info("Register deleted successfully!");
        ResponseEntity<String> response = ResponseEntity.ok("Appointment successfully deleted!");
        return response;
    }
}

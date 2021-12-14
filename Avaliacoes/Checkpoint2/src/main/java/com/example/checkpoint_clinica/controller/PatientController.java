package com.example.checkpoint_clinica.controller;

import com.example.checkpoint_clinica.exceptionhandler.IllegalDataException;
import com.example.checkpoint_clinica.persistence.entities.PatientEntity;
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
@RequestMapping("/patients")
public class PatientController {

    private static final Logger logger = LogManager.getLogger(PatientController.class);

    @Autowired
    private PatientServiceImpl patientService;

    //Setting POST
    @PostMapping("/save")
    public ResponseEntity saveAndFlush(@Valid @RequestBody PatientEntity patient) {

        logger.info("Patient registered successfully!");
        return ResponseEntity.ok(patientService.saveAndFlush(patient));
    }

    //Setting GET
    @GetMapping("/list")
    public ResponseEntity findAll() {

        List<PatientEntity> patientEntity = patientService.findAll();

        //Setting 404 return
        if(patientEntity.isEmpty()) {
            logger.error("There aren't patients registered");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("There aren't patients registered");
        }

        //Setting 200 Return
        logger.info("Registers recovered successfully!");
        return ResponseEntity.ok(patientEntity);
    }

    @GetMapping("/list/{id}")
    public ResponseEntity findById(@PathVariable Integer id) {

        Optional<PatientEntity> patientEntity = patientService.findById(id);

        //Setting 404 return
        if(patientEntity.isEmpty()) {
            logger.error("There there's no patient registered with this ID");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("There there's no patient registered with this ID");
        }

        //Setting 200 Return
        logger.info("Register recovered successfully!");
        return ResponseEntity.ok(patientEntity);
    }

    @PutMapping("/update")
    public ResponseEntity update (@RequestBody PatientEntity patient){

        Optional<PatientEntity> patientEntity = patientService.findById(patient.getId());

        //Setting 404 returns
        if(patientEntity.isEmpty()) {
            logger.error("Couldn't update because there's no patient registered with this ID");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Couldn't update because there's no patient registered with this ID");
        }

        try {
            //Setting 200 Return
            ResponseEntity response = ResponseEntity.ok(patientService.update(patient));
            logger.info("Patient updated successfully!");
            return response;
            //Setting 200 Return
        } catch (IllegalArgumentException ex) {
            logger.error("Incorrect object! This endpoint only accepts JSON objects!");
            throw new IllegalDataException("Incorrect object! This endpoint only accepts JSON objects!");

        } catch (Exception ex) {
            logger.error("Incorrect data informed. Please, check the exception message and try again!");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){

        Optional<PatientEntity> patientEntity = patientService.findById(id);

        //Setting 404 return
        if(patientEntity.isEmpty()){
            logger.error("Couldn't delete because there's no patient registered with this ID");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Couldn't delete because there's no patient registered with this ID");
        }

        patientService.deleteById(id);

        //Setting 200 Return
        logger.info("Register deleted successfully!");
        ResponseEntity<String> response = ResponseEntity.ok("Patient successfully deleted!");

        return response;
    }
}

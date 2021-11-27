package com.example.checkpoint_clinica.controller;

import com.example.checkpoint_clinica.persistence.entities.PatientEntity;
import com.example.checkpoint_clinica.services.impl.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

//Mapping paths
@RestController
@RequestMapping("/patients")
public class PatientController {

    private static final Logger logger = Logger.getLogger(String.valueOf(PatientController.class));

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
            logger.warning("There aren't patients registered");
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
            logger.warning("There there's no patient registered with this ID");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("There there's no patient registered with this ID");
        }

        //Setting 200 Return
        logger.info("Register recovered successfully!");
        return ResponseEntity.ok(patientEntity);
    }

    @PutMapping("/update")
    public ResponseEntity update (@RequestBody PatientEntity patient){

        Optional<PatientEntity> patientEntity = patientService.findById(patient.getId());

        //Setting 404 return
        if(patientEntity.isEmpty()) {
            logger.warning("Couldn't update because there's no patient registered with this ID");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Couldn't update because there's no patient registered with this ID");
        }

        //Setting 200 Return
        logger.info("Register updated successfully!");
        return ResponseEntity.ok(patientService.update(patient));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){

        Optional<PatientEntity> patientEntity = patientService.findById(id);

        //Setting 404 return
        if(patientEntity.isEmpty()){
            logger.warning("Couldn't delete because there's no patient registered with this ID");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Couldn't delete because there's no patient registered with this ID");
        }

        patientService.deleteById(id);

        //Setting 200 Return
        logger.info("Register deleted successfully!");
        ResponseEntity<String> response = ResponseEntity.ok("Patient successfully deleted!");

        return response;
    }
}

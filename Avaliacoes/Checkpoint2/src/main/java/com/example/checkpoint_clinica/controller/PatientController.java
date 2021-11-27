package com.example.checkpoint_clinica.controller;

import com.example.checkpoint_clinica.persistence.entities.DentistEntity;
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

@RestController
@RequestMapping("/patients")
public class PatientController {

    private static final Logger logger = Logger.getLogger(String.valueOf(PatientController.class));

    @Autowired
    private PatientServiceImpl patientService;

    @PostMapping("/save")
    public ResponseEntity saveAndFlush(@Valid @RequestBody PatientEntity patient) {return ResponseEntity.ok(patientService.saveAndFlush(patient));}

    @GetMapping
    public ResponseEntity findAll() {

        List<PatientEntity> patientEntity = patientService.findAll();

        if(patientEntity.isEmpty()) {
            logger.warning("There aren't patients registered");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("There aren't patients registered");
        }

        logger.info("Registers recovered successfully!");
        return ResponseEntity.ok(patientEntity);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Integer id) {

        Optional<PatientEntity> patientEntity = patientService.findById(id);

        if(patientEntity.isEmpty()) {
            logger.warning("There there's no patient registered with this ID");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("There there's no patient registered with this ID");
        }

        logger.info("Register recovered successfully!");
        return ResponseEntity.ok(patientEntity);
    }

    @PutMapping
    public ResponseEntity update (@RequestBody PatientEntity patient){

        Optional<PatientEntity> patientEntity = patientService.findById(patient.getId());

        if(patientEntity.isEmpty()) {
            logger.warning("Couldn't update because there's no patient registered with this ID");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Couldn't update because there's no patient registered with this ID");
        }

        logger.info("Register updated successfully!");
        return ResponseEntity.ok(patientService.update(patient));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){

        Optional<PatientEntity> patientEntity = patientService.findById(id);

        if(patientEntity.isEmpty()){
            logger.warning("Couldn't delete because there's no patient registered with this ID");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Couldn't delete because there's no patient registered with this ID");
        }

        patientService.deleteById(id);

        logger.info("Register deleted successfully!");
        ResponseEntity<String> response = ResponseEntity.ok("Patient successfully deleted!");

        return response;
    }
}

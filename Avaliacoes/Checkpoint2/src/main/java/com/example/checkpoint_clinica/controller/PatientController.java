package com.example.checkpoint_clinica.controller;

import com.example.checkpoint_clinica.persistence.entities.PatientEntity;
import com.example.checkpoint_clinica.services.impl.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientServiceImpl patientService;

    @PostMapping("/save")
    public ResponseEntity saveAndFlush(@RequestBody PatientEntity patient) {return ResponseEntity.ok(patientService.saveAndFlush(patient));}

    @GetMapping
    public ResponseEntity findAll() {return ResponseEntity.ok(patientService.findAll());}

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Integer id) {return ResponseEntity.ok(patientService.findById(id));}

    @PutMapping
    public ResponseEntity update (@RequestBody PatientEntity patient){
        return ResponseEntity.ok(patientService.update(patient));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){
        patientService.deleteById(id);
        ResponseEntity<String> response = ResponseEntity.ok("Patient successfully deleted!");

        return response;
    }
}

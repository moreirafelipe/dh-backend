package com.example.checkpoint_clinica.controller;

import com.example.checkpoint_clinica.persistence.entities.DentistEntity;
import com.example.checkpoint_clinica.services.impl.DentistServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dentists")
public class DentistController{

    @Autowired
    private DentistServiceImpl dentistService;

    @PostMapping("/save")
    public ResponseEntity saveAndFlush(@RequestBody DentistEntity dentist) {return ResponseEntity.ok(dentistService.saveAndFlush(dentist));}

    @GetMapping
    public ResponseEntity findAll() {return ResponseEntity.ok(dentistService.findAll());}

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Integer id) {return ResponseEntity.ok(dentistService.findById(id));}

    @PutMapping
    public ResponseEntity update (@RequestBody DentistEntity dentist){
        return ResponseEntity.ok(dentistService.update(dentist));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){
        dentistService.deleteById(id);
        ResponseEntity<String> response = ResponseEntity.ok("Dentist successfully deleted!");
        return response;
    }
}

package com.example.checkpoint_clinica.controller;

import com.example.checkpoint_clinica.persistence.entities.DentistEntity;
import com.example.checkpoint_clinica.services.impl.DentistServiceImpl;
import org.jboss.jandex.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Logger;

import static java.util.Objects.isNull;

@RestController
@RequestMapping("/dentists")
public class DentistController{

    private static final Logger logger = Logger.getLogger(String.valueOf(DentistController.class));

    @Autowired
    private DentistServiceImpl dentistService;

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity saveAndFlush(@Valid @RequestBody DentistEntity dentist) {
        return ResponseEntity.ok(dentistService.saveAndFlush(dentist));
    }

    @GetMapping
    public ResponseEntity findAll() {

        List<DentistEntity> dentistEntity = dentistService.findAll();
        if(dentistEntity.isEmpty()){
            logger.warning("There aren't dentists registered");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("There aren't dentists registered");
        }

        logger.info("Registers recovered successfully!");
        return ResponseEntity.ok(dentistEntity);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Integer id) {
        Optional<DentistEntity> dentistEntity = dentistService.findById(id);

        if(dentistEntity.isEmpty()){
            logger.warning("There there's no dentist registered with this ID");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("There there's no dentist registered with this ID");
        }

        logger.info("Register recovered successfully!");
        return ResponseEntity.ok(dentistEntity);
    }

    @PutMapping
    public ResponseEntity update (@RequestBody DentistEntity dentist){
        Optional<DentistEntity> dentistEntity = dentistService.findById(dentist.getId());

        if(dentistEntity.isEmpty()){
            logger.warning("Couldn't update because there's no dentist registered with this ID");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Couldn't update because there's no dentist registered with this ID");
        }

        logger.info("Register updated successfully!");
        return ResponseEntity.ok(dentistService.update(dentist));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){
        Optional<DentistEntity> dentistEntity = dentistService.findById(id);

        if(dentistEntity.isEmpty()) {
            logger.warning("Couldn't delete because there's no dentist registered with this ID");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Couldn't delete because there's no dentist registered with this ID");
        }

        dentistService.deleteById(id);

        logger.info("Register updated successfully!");
        ResponseEntity<String> response = ResponseEntity.ok("Dentist successfully deleted!");
        return response;
    }
}

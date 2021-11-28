package com.example.checkpoint_clinica.controller;

import com.example.checkpoint_clinica.exceptionhandler.GlobalExceptionHandler;
import com.example.checkpoint_clinica.exceptionhandler.IllegalDataException;
import com.example.checkpoint_clinica.persistence.entities.DentistEntity;
import com.example.checkpoint_clinica.services.impl.DentistServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

//Mapping paths
@RestController
@RequestMapping("/dentists")
public class DentistController{

    private static final Logger logger = LogManager.getLogger(DentistController.class);

    @Autowired
    private DentistServiceImpl dentistService;

    //Setting POST
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity saveAndFlush(@Valid @RequestBody DentistEntity dentist) {
        logger.info("Dentist registered successfully!");
        return ResponseEntity.ok(dentistService.saveAndFlush(dentist));
    }

    //Setting GET
    @GetMapping("/list")
    public ResponseEntity findAll() {

        //Setting 404 return
        List<DentistEntity> dentistEntity = dentistService.findAll();
        if(dentistEntity.isEmpty()){
            logger.error("There aren't dentists registered");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("There aren't dentists registered");
        }

        //Setting 200 Return
        logger.info("Registers recovered successfully!");
        return ResponseEntity.ok(dentistEntity);
    }

    @GetMapping("/list/{id}")
    public ResponseEntity findById(@PathVariable Integer id) {
        Optional<DentistEntity> dentistEntity = dentistService.findById(id);

        //Setting 404 return
        if(dentistEntity.isEmpty()){
            logger.error("There there's no dentist registered with this ID");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("There there's no dentist registered with this ID");
        }

        //Setting 200 Return
        logger.info("Register recovered successfully!");
        return ResponseEntity.ok(dentistEntity);
    }

    //Setting UPDATE
    @PutMapping("/update")
    public ResponseEntity update (@RequestBody DentistEntity dentist){
        Optional<DentistEntity> dentistEntity = dentistService.findById(dentist.getId());

        //Setting 404 return
        if(dentistEntity.isEmpty()){
            logger.error("Couldn't update because there's no dentist registered with this ID");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Couldn't update because there's no dentist registered with this ID");
        }

        try {
            //Setting 200 Return
            ResponseEntity response = ResponseEntity.ok(dentistService.update(dentist));
            logger.info("Dentist updated successfully!");
            return response;
        } catch (Exception ex) {
            logger.error("Incorrect data informed. Please, check the exception message and try again!");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
   }

    //Setting DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){
        Optional<DentistEntity> dentistEntity = dentistService.findById(id);

        //Setting 404 return
        if(dentistEntity.isEmpty()) {
            logger.error("Couldn't delete because there's no dentist registered with this ID");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Couldn't delete because there's no dentist registered with this ID");
        }

        dentistService.deleteById(id);

        //Setting 200 Return
        logger.info("Register deleted successfully!");
        ResponseEntity<String> response = ResponseEntity.ok("Dentist successfully deleted!");
        return response;
    }
}

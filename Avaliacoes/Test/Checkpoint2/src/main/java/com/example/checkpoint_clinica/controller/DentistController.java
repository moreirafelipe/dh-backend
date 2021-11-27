package com.example.checkpoint_clinica.controller;

import com.example.checkpoint_clinica.persistence.entities.DentistEntity;
import com.example.checkpoint_clinica.services.impl.DentistServiceImpl;
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
@RequestMapping("/dentists")
public class DentistController{

    private static final Logger logger = Logger.getLogger(String.valueOf(DentistController.class));

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
            logger.warning("There aren't dentists registered");
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
            logger.warning("There there's no dentist registered with this ID");
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
            logger.warning("Couldn't update because there's no dentist registered with this ID");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Couldn't update because there's no dentist registered with this ID");
        }

        //Setting 200 Return
        logger.info("Register updated successfully!");
        return ResponseEntity.ok(dentistService.update(dentist));
    }

    //Setting DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){
        Optional<DentistEntity> dentistEntity = dentistService.findById(id);

        //Setting 404 return
        if(dentistEntity.isEmpty()) {
            logger.warning("Couldn't delete because there's no dentist registered with this ID");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Couldn't delete because there's no dentist registered with this ID");
        }

        dentistService.deleteById(id);

        //Setting 200 Return
        logger.info("Register deleted successfully!");
        ResponseEntity<String> response = ResponseEntity.ok("Dentist successfully deleted!");
        return response;
    }
}

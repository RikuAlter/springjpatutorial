package com.springjpa_tutorial.jpademo.controller;

import com.springjpa_tutorial.jpademo.entity.Patient;
import com.springjpa_tutorial.jpademo.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping(path = "patients")
public class PatientRegistryController {

    @Autowired
    private PatientRepository patientRepository;

    @PostMapping("/register")
    public ResponseEntity<String> registerPatient(Patient patient){
        if(Objects.nonNull(patient)){
            var savedPatient = patientRepository.save(patient);
            return new ResponseEntity<>("Patient is registered", HttpStatus.CREATED);
        } else
            return new ResponseEntity<>("Bad patient details supplied", HttpStatus.BAD_REQUEST);
    }

}

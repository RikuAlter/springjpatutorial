package com.springjpa_tutorial.jpademo.controller;

import com.springjpa_tutorial.jpademo.entity.Doctor;
import com.springjpa_tutorial.jpademo.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("staff")
public class StaffController {

    @Autowired
    private DoctorRepository doctorRepository;

    @PostMapping("/doctors")
    public ResponseEntity<String> registerNewDoctor(@RequestBody Doctor doctor) {
        if(Objects.nonNull(doctor)){
            var savedDoctor = doctorRepository.save(doctor);
            return new ResponseEntity<>("Entity created with ID: "+savedDoctor.getId(), HttpStatus.CREATED);
        } else
            return new ResponseEntity<>("Bad entity value supplied", HttpStatus.BAD_REQUEST);
    }
}

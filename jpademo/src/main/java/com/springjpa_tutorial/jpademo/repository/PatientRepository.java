package com.springjpa_tutorial.jpademo.repository;

import com.springjpa_tutorial.jpademo.entity.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient, Integer> {
}

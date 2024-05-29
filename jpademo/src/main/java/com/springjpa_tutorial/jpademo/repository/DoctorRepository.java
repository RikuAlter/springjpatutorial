package com.springjpa_tutorial.jpademo.repository;

import com.springjpa_tutorial.jpademo.entity.Doctor;
import org.springframework.data.repository.CrudRepository;

public interface DoctorRepository extends CrudRepository<Doctor, Integer> {
}

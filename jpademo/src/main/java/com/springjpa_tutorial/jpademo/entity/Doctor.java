package com.springjpa_tutorial.jpademo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "doctor", schema = "hospitalmanager")
@Data
@Builder
public class Doctor {

    @Id
    @Column(name = "id")
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hospitalmanager.doctor_id_gen")
    private int id;
    @Column(name = "name", length = 255, nullable = false)
    private String name;
    @Column(name = "email", length = 255, nullable = false, unique = true)
    private String email;
    @Column(name = "specialization", length = 255, nullable = false)
    private String specialization;
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "assignedDoc", fetch = FetchType.LAZY)
    private List<Patient> patients;
}

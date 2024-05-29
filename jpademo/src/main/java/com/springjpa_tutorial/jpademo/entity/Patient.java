package com.springjpa_tutorial.jpademo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "patient", schema = "hospitalmanager")
@Data
@Builder
public class Patient {

    @Id
    @Column(name = "id")
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hospitalmanager.patient_id_gen")
    private int id;
    @Column(name = "name", length = 255, nullable = false)
    private String name;
    @Column(name = "issue", length = 255, nullable = false)
    private String issue;
    @ManyToOne
    @JoinColumn(name = "assigned_doc", referencedColumnName = "id")
    private Doctor assignedDoc;
}

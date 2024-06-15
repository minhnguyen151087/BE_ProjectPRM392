package com.example.ProjectPRM392.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Disease",uniqueConstraints = {@UniqueConstraint(columnNames = {"disease_id"})})
public class Disease {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "disease_id")
    private int diseaseId;
    @Column(name = "disease_name")
    private String diseaseName;
    @Column(name = "description")
    private String description;
    @ManyToMany
    Set<Doctor> doctors;
}

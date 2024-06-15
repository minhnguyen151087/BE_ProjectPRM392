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
@Table(name = "Doctor",uniqueConstraints = {@UniqueConstraint(columnNames = {"doctor_id"})})
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="doctor_id")
    private int doctorId;
    @Column(name = "doctor_name")
    private String doctorName;
    @Column(name = "history_of_treatment")
    private String historyOfTreatment;
    @Column(name = "major")
    private String major;
    @ManyToMany
    @JoinTable(
            name = "disease_doctor",
            joinColumns = @JoinColumn(name = "doctor_id"),
            inverseJoinColumns = @JoinColumn(name = "disease_id"))
    Set<Disease> diseases;
}

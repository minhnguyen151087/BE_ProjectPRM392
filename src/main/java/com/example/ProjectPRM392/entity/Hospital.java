package com.example.ProjectPRM392.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Hospital",uniqueConstraints = {@UniqueConstraint(columnNames = {"hospital_id"})})
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="hospital_id")
    private int hospitalId;
    @Column(name = "hospital_name")
    private String hospitalName;
    @Column(name = "address")
    private String address;
    @Column(name = "image")
    private String image;
}

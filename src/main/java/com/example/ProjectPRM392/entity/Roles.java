package com.example.ProjectPRM392.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Roles",uniqueConstraints = {@UniqueConstraint(columnNames = {"role_id"})})
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="role_id")
    private int roleId;
    @Column(name="role_name")
    private String role_name;
    @Column(name="description")
    private String description;
    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private List<Users> userList;
}

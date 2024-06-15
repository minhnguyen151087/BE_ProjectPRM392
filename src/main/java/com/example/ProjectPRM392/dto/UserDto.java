package com.example.ProjectPRM392.dto;

import com.example.ProjectPRM392.entity.Booking;
import com.example.ProjectPRM392.entity.Roles;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {
    private int userId;
    private String userName;
    private String password;
    private String name;
    private Date dob;
    private int phoneNumber;
    private String address;
    private Roles role;
    private List<Booking> orders;

}

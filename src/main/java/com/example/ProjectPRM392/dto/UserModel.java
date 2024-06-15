package com.example.ProjectPRM392.dto;

import com.example.ProjectPRM392.entity.Roles;
import com.example.ProjectPRM392.entity.Users;
import lombok.Data;

@Data
public class UserModel {
    private Users user;
    private String token;
    private String tokenType = "Bearer ";
    private Roles Role;

    public UserModel(Users user, String token, Roles role) {
        this.user = user;
        this.token = token;
        Role = role;
    }
}

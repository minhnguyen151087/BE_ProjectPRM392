package com.example.ProjectPRM392.dto;

import com.example.ProjectPRM392.entity.Roles;
import com.example.ProjectPRM392.entity.Users;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.List;
@Data
public class RoleDto {
    private String roleId;
    private String role_name;
    private String description;
    private List<Users> userList;
}

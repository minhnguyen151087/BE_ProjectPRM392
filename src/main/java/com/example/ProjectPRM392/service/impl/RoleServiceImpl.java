package com.example.ProjectPRM392.service.impl;

import com.example.ProjectPRM392.dto.RoleDto;
import com.example.ProjectPRM392.entity.Roles;
import com.example.ProjectPRM392.repository.RoleRepository;
import com.example.ProjectPRM392.service.RoleService;
import org.modelmapper.ModelMapper;

public class RoleServiceImpl implements RoleService {
    private RoleRepository roleRepository;
    private ModelMapper modelMapper;

    @Override
    public Roles getRoleById(int roleId) {
        return roleRepository.getRoleById(roleId);
    }
}

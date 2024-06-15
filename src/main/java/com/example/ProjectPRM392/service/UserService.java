package com.example.ProjectPRM392.service;

import com.example.ProjectPRM392.dto.UserDto;
import com.example.ProjectPRM392.entity.Users;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface UserService {
    UserDto getByUserName(String userName);

    Users loadUserByUserNameAndPassword(String username, String password);


    ResponseEntity<?> register(UserDto userRequest);
    Boolean existUserNamePassword(String userName);
}

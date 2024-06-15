package com.example.ProjectPRM392.service.impl;

import com.example.ProjectPRM392.dto.UserDto;
import com.example.ProjectPRM392.entity.Roles;
import com.example.ProjectPRM392.entity.Users;
import com.example.ProjectPRM392.repository.UserRepository;
import com.example.ProjectPRM392.service.RoleService;
import com.example.ProjectPRM392.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private ModelMapper modelMapper;
    @Override
    public UserDto getByUserName(String userName) {
        Users user = userRepository.findByUserName(userName);
        return modelMapper.map(user,UserDto.class);
    }
    @Override
    public Users loadUserByUserNameAndPassword(String username, String password){
        Users user = userRepository.loadUserByUserNameAndPassword(username,password);
        return user;
    }



    @Override
    public ResponseEntity<?> register(UserDto userRequest) {
        Users newUser =new Users();
        newUser.setUserName(userRequest.getUserName());
        newUser.setPassword(userRequest.getPassword());
        newUser.setName(userRequest.getName());
        newUser.setDob(userRequest.getDob());
        newUser.setAddress(userRequest.getAddress());
        newUser.setPhoneNumber(userRequest.getPhoneNumber());
        userRepository.saveUser(newUser.getUserName(), newUser.getPassword(), newUser.getName(),
                newUser.getDob(), newUser.getPhoneNumber(), newUser.getAddress(), 1);
        return new ResponseEntity<>( newUser,HttpStatus.OK);
    }

    @Override
    public Boolean existUserNamePassword(String userName) {
        return userRepository.existsByUserName(userName);
    }
}

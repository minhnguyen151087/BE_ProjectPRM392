package com.example.ProjectPRM392.controller;

import com.example.ProjectPRM392.config.JwtTokenUtil;
import com.example.ProjectPRM392.config.JwtUserService;
import com.example.ProjectPRM392.dto.UserDto;
import com.example.ProjectPRM392.dto.UserModel;
import com.example.ProjectPRM392.entity.Roles;
import com.example.ProjectPRM392.entity.Users;
import com.example.ProjectPRM392.service.RoleService;
import com.example.ProjectPRM392.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RestController
public class UserController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    JwtUserService jwtUserService;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    JwtTokenUtil jwtTokenUtil;
    @PostMapping("/sigin")
    public ResponseEntity<?> authenticate(@Valid @RequestBody UserDto userDto){
        Users user = userService.loadUserByUserNameAndPassword(userDto.getUserName(),userDto.getPassword());
        if(userDto != null){
            modelMapper.map(user,UserDto.class);
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            userDto.getUserName(),
                            userDto.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String token = jwtTokenUtil.generateToken(authentication);
            return new ResponseEntity<>(new UserModel(user,token,user.getRole()), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Tên đăng nhập hoặc mật khẩu không đúng!", HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDto userDTO){
        if(userService.existUserNamePassword(userDTO.getUserName())){
            return new ResponseEntity<>("Người dùng đã tồn tại ", HttpStatus.BAD_REQUEST);
        }
        userService.register(userDTO);
        return new ResponseEntity<>("Đăng ký thành công",HttpStatus.OK);
    }
}

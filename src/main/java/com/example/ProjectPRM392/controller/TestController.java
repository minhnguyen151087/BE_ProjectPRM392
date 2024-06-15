package com.example.ProjectPRM392.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/")
    public String getHome(){
        return "HomePage";
    }
    @GetMapping("/test")
    public String getTest(){
        return "Hello from test";
    }
    @GetMapping("/app/adminPage")
    public String getAdmin(){
        return "AdminPage";
    }
}

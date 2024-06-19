package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/admins")
@RestController
public class AdminController {

    @RequestMapping("/hi")
    public String list() {
        return "Hii, admin! This is an interface without authentication!";
    }

    @RequestMapping("/hi2")
    public String list2() {
        return "Hello, 222! This is an interface with authentication!";
    }
}
package com.waylau.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/admins")
@RestController
public class AdminController {

    @RequestMapping("/hi")
    public String list() {
        return "Hello, admin!";
    }
}
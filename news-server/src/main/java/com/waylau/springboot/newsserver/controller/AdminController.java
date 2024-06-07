package com.waylau.springboot.newsserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/admins")
@RestController
public class AdminController {

    @RequestMapping("/hi")
    public String list() {
        return "Hii, admin!";
    }

    @RequestMapping("/hi2")
    public String list2() {
        return "Hello, 222!";
    }
}
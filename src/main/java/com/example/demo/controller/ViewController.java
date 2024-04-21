package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ViewController {

    @RequestMapping("hello")
    public String Hello(){
        return "Hello Springboot";
    }
}

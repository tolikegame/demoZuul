package com.example.clienta.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class TestCotroller {

    @GetMapping("/add")
    public Integer add(Integer a, Integer b){
        return a+b;
    }

    @GetMapping("/testRibbon")
    public String add(Integer a, Integer b, HttpServletRequest request){
        return " From Port: "+ request.getServerPort() + ", Result: " + (a + b);
    }
}

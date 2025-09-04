package com.demo.pingpoint.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloworldController {

    @GetMapping("/Hello")
    public String print(){
        System.out.print("Hi");
        return "Hello World";
    }
}

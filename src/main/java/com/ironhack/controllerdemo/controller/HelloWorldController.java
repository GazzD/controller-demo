package com.ironhack.controllerdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

//    @RequestMapping(value = "/hello-world", method = RequestMethod.GET)
    @GetMapping("/hello-world")
    public String greater() {
        return "<h1>Hello World</h1>";
    }

}
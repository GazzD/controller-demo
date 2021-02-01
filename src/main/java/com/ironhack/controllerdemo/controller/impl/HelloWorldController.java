package com.ironhack.controllerdemo.controller.impl;

import com.ironhack.controllerdemo.controller.interfaces.IHelloWorldController;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class HelloWorldController implements IHelloWorldController {

    @GetMapping("/hello-world")
    public String greaterWithRequestParams(@RequestParam Optional<String> firstName, @RequestParam Optional<String> lastName) {

        StringBuilder response = new StringBuilder("Hello");

        if (firstName.isPresent()) {
            response.append(" " + firstName.get());
        }

        if (lastName.isPresent()) {
            response.append(" " + lastName.get());
        }

        if (!firstName.isPresent() && !lastName.isPresent()) {
            response.append(" World");
        }

        return response.toString();
    }

    @GetMapping("/hello-world/{name}")
    public String greaterWithPathVariable(@PathVariable String name) {

        return "Hello " + name;
    }

}
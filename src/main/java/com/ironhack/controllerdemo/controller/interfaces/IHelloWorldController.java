package com.ironhack.controllerdemo.controller.interfaces;

import java.util.Optional;

public interface IHelloWorldController {
    public String greaterWithRequestParams(Optional<String> firstName, Optional<String> lastName);
    public String greaterWithPathVariable(String name);
}

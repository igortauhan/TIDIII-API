package com.excentricdevs.presp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/esp")
public class EspController {

    @GetMapping
    public String test() {
        return "Hello, world!";
    }
}

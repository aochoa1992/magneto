package com.magneto.magneto.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class health {
    @GetMapping("/")
    public String health() {
        return "Magneto Ok!!";
    }
}

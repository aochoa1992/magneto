package com.magneto.magneto.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class MutantController {

    @GetMapping("/mutant")
    public int getMutant() {
        return 1;
    }
}

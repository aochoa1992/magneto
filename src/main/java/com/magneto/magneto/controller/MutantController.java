package com.magneto.magneto.controller;

import com.magneto.magneto.services.IMutantService;
import com.magneto.magneto.services.IStatsService;
import com.magneto.magneto.utils.InputValidations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MutantController {

    private final IMutantService mutantService;
    private final InputValidations inputValidations;

    @Autowired
    public MutantController(IMutantService mutantService, InputValidations inputValidations) {
        this.mutantService = mutantService;
        this.inputValidations = inputValidations;
    }

    @PostMapping("/mutant")
    public ResponseEntity getMutant(@RequestBody List<String> dna) {
        if(inputValidations.validateEachSequence(dna) && inputValidations.validateString(dna.toString())
                && inputValidations.validateSizeArray(dna)) {
            if (this.mutantService.isMutant(dna)) {
                return ResponseEntity.ok(HttpStatus.OK);
            }
            return ResponseEntity.ok(HttpStatus.FORBIDDEN);
        }
        return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
    }
}

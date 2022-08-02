package com.magneto.magneto.controller;

import com.magneto.magneto.model.Stats;
import com.magneto.magneto.services.IMutantService;
import com.magneto.magneto.services.IStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MutantController {

    private final IMutantService mutantService;
    private final IStatsService statsService;

    @Autowired
    public MutantController(IMutantService mutantService, IStatsService statsService) {
        this.mutantService = mutantService;
        this.statsService = statsService;
    }

    @PostMapping("/mutant")
    public ResponseEntity getMutant(@RequestBody List<String> dna) {
        if(this.mutantService.isMutant(dna)) {
            return ResponseEntity.ok(HttpStatus.OK);
        }
        return ResponseEntity.ok(HttpStatus.FORBIDDEN);
    }

    @GetMapping("/stats")
    public Stats getStats() {
        return statsService.getStats();
    }
}

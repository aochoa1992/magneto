package com.magneto.magneto.controller;

import com.magneto.magneto.model.Stats;
import com.magneto.magneto.services.IMutantService;
import com.magneto.magneto.services.IStatsService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

class MutantControllerTest {

    MutantController mutantController;

    @Mock
    IMutantService mutantService;

    @Mock
    IStatsService statsService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mutantController = new MutantController(mutantService, statsService);
    }

    @Test
    void getMutant_Ok() {
        List<String> dna = new ArrayList<>();
        dna.add("ATGCGA");
        dna.add("CAGTGC");
        dna.add("TTATGT");
        dna.add("AGAAGG");
        dna.add("CCCCTA");
        dna.add("TCACTG");

        when(mutantService.isMutant(dna)).thenReturn(true);
        ResponseEntity result = mutantController.getMutant(dna);

        Assert.assertEquals(ResponseEntity.ok(HttpStatus.OK), result);
    }


    @Test
    void getMutant_FORBIDDEN() {
        List<String> dna = new ArrayList<>();
        dna.add("ATGCGA");
        dna.add("CAGTGC");
        dna.add("TTATGT");
        dna.add("AGAAGG");
        dna.add("CCCTTA");
        dna.add("TCACTG");

        when(mutantService.isMutant(dna)).thenReturn(false);
        ResponseEntity result = mutantController.getMutant(dna);

        Assert.assertEquals(ResponseEntity.ok(HttpStatus.FORBIDDEN), result);
    }

    @Test
    void getStats() {
        Stats stats =  new Stats();
        stats.setCountHumanDna(100);
        stats.setCountMutantDna(40);
        stats.setRatio(stats.getCountMutantDna() / stats.getCountHumanDna());

        when(statsService.getStats()).thenReturn(stats);
        Stats result =  mutantController.getStats();

        Assert.assertEquals(stats , result);
    }
}

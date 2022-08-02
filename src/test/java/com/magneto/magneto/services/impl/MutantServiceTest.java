package com.magneto.magneto.services.impl;

import com.magneto.magneto.persistence.entities.DnaEntity;
import com.magneto.magneto.services.IDnaService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

class MutantServiceTest {

    MutantService mutantService;

    @Mock
    IDnaService dnaService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mutantService = new MutantService(dnaService);
    }

    @Test
    void isMutant_Success() {
        List<String> dna = new ArrayList<>();
        dna.add("ATGCGA");
        dna.add("CAGTGC");
        dna.add("TTATGT");
        dna.add("AGAAGG");
        dna.add("CCCCTA");
        dna.add("TCACTG");

        DnaEntity dnaEntity = new DnaEntity();
        dnaEntity.setId(1L);
        dnaEntity.setSequence(dna.toString());
        dnaEntity.setIsMutant(true);

        when(dnaService.saveDNA(dna, true)).thenReturn(dnaEntity);

        boolean result = mutantService.isMutant(dna);
        Assert.assertEquals(true, result);

    }

    @Test
    void isNotMutant_Success() {
        List<String> dna = new ArrayList<>();
        dna.add("ATGCGA");
        dna.add("CAGTGC");
        dna.add("TTATGT");
        dna.add("AGAAGG");
        dna.add("CCCTTA");
        dna.add("TCACTG");

        DnaEntity dnaEntity = new DnaEntity();
        dnaEntity.setId(1L);
        dnaEntity.setSequence(dna.toString());
        dnaEntity.setIsMutant(true);

        when(dnaService.saveDNA(dna, true)).thenReturn(dnaEntity);

        boolean result = mutantService.isMutant(dna);
        Assert.assertEquals(false, result);

    }
}

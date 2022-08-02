package com.magneto.magneto.services.impl;

import com.magneto.magneto.persistence.entities.DnaEntity;
import com.magneto.magneto.persistence.repositories.DnaRepository;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class DnaServiceTest {

    DnaService dnaService;

    @Mock
    DnaRepository dnaRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        dnaService = new DnaService(dnaRepository);
    }

    @Test
    void saveDNA() {
        List<String> dna = new ArrayList<>();
        dna.add("ATGCGA");
        dna.add("CAGTGC");
        dna.add("TTATGT");
        dna.add("AGAAGG");
        dna.add("CCCCTA");
        dna.add("TCACTG");

        DnaEntity dnaEntity = new DnaEntity();
        dnaEntity.setSequence(dna.toString());
        dnaEntity.setIsMutant(true);

        when(dnaRepository.save(any())).thenReturn(dnaEntity);

        DnaEntity result = dnaService.saveDNA(dna, true);

        Assert.assertEquals(dnaEntity, result);
    }

    @Test
    void getDNA() {
        List<String> dna = new ArrayList<>();
        dna.add("ATGCGA");
        dna.add("CAGTGC");
        dna.add("TTATGT");
        dna.add("AGAAGG");
        dna.add("CCCCTA");
        dna.add("TCACTG");

        List<String> dnaSecond = new ArrayList<>();
        dnaSecond.add("ATGCGA");
        dnaSecond.add("CAGTGC");
        dnaSecond.add("TTATGT");
        dnaSecond.add("AGAAGG");
        dnaSecond.add("CCCCTA");
        dnaSecond.add("TCACTG");

        List<DnaEntity> listEntity = new ArrayList<>();
        DnaEntity dnaEntity = new DnaEntity();
        dnaEntity.setId(1L);
        dnaEntity.setSequence(dna.toString());
        dnaEntity.setIsMutant(true);

        DnaEntity dnaEntitySecond = new DnaEntity();
        dnaEntitySecond.setId(2L);
        dnaEntitySecond.setSequence(dna.toString());
        dnaEntitySecond.setIsMutant(true);

        listEntity.add(dnaEntity);
        listEntity.add(dnaEntitySecond);

        when(dnaRepository.findAll()).thenReturn(listEntity);

        List<DnaEntity> result = dnaService.getDna();

        Assert.assertEquals(listEntity, result);
    }
}

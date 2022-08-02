package com.magneto.magneto.services.impl;

import com.magneto.magneto.model.Stats;
import com.magneto.magneto.persistence.entities.DnaEntity;
import com.magneto.magneto.services.IDnaService;
import com.magneto.magneto.services.IStatsService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

class StatsServiceTest {

     IStatsService statsService;

     @Mock
     IDnaService dnaService;

     @BeforeEach
     public void setup() {
         MockitoAnnotations.openMocks(this);
         statsService = new StatsService(dnaService);
     }

     @Test
     void getStats() {

         List<DnaEntity> list = new ArrayList<>();
         DnaEntity dnaEntity = new DnaEntity();
         dnaEntity.setId(1L);
         dnaEntity.setSequence("[ATGCGA, CAGTGC, TTATGT, AGAAGG, CCCCTA, TCACTG]");
         dnaEntity.setIsMutant(true);
         list.add(dnaEntity);

         DnaEntity dnaEntityIsNotMutant = new DnaEntity();
         dnaEntityIsNotMutant.setId(1L);
         dnaEntityIsNotMutant.setSequence("[ATGCGA, CAGTGC, TTATGT, AGAAGG, CCCTTA, TCACTG]");
         dnaEntityIsNotMutant.setIsMutant(false);
         list.add(dnaEntityIsNotMutant);

         Stats stats = new Stats();
         stats.setRatio(1.0);
         stats.setCountMutantDna(1);
         stats.setCountHumanDna(1);

         when(dnaService.getDna()).thenReturn(list);

         Stats result = statsService.getStats();
         Assert.assertEquals(stats, result);
     }


    @Test
    void getStatsOnlyMutants() {

        List<DnaEntity> list = new ArrayList<>();
        DnaEntity dnaEntity = new DnaEntity();
        dnaEntity.setId(1L);
        dnaEntity.setSequence("[ATGCGA, CAGTGC, TTATGT, AGAAGG, CCCCTA, TCACTG]");
        dnaEntity.setIsMutant(true);
        list.add(dnaEntity);

        DnaEntity dnaEntityIsNotMutant = new DnaEntity();
        dnaEntityIsNotMutant.setId(1L);
        dnaEntityIsNotMutant.setSequence("[ATGCGA, CAGTGC, TTATGT, AGAAGG, CCCCTA, TCACTG]");
        dnaEntityIsNotMutant.setIsMutant(true);
        list.add(dnaEntityIsNotMutant);

        Stats stats = new Stats();
        stats.setRatio(0.0);
        stats.setCountMutantDna(2);
        stats.setCountHumanDna(0);

        when(dnaService.getDna()).thenReturn(list);

        Stats result = statsService.getStats();
        Assert.assertEquals(stats, result);
    }
}

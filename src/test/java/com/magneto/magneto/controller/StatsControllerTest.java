package com.magneto.magneto.controller;

import com.magneto.magneto.model.Stats;
import com.magneto.magneto.services.IStatsService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

public class StatsControllerTest {

    StatsController statsController;

    @Mock
    IStatsService iStatsService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        statsController = new StatsController(iStatsService);
    }

    @Test
    void getStats() {
        Stats stats =  new Stats();
        stats.setCountHumanDna(100);
        stats.setCountMutantDna(40);
        stats.setRatio(stats.getCountMutantDna() / stats.getCountHumanDna());

        when(iStatsService.getStats()).thenReturn(stats);
        Stats result =  statsController.getStats();

        Assert.assertEquals(stats , result);
    }
}

package com.magneto.magneto.controller;

import com.magneto.magneto.model.Stats;
import com.magneto.magneto.services.IStatsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatsController {

    private final IStatsService statsService;

    public StatsController(IStatsService statsService) { this.statsService = statsService; }

    @GetMapping("/stats")
    public Stats getStats() {
        return statsService.getStats();
    }
}

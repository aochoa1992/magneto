package com.magneto.magneto.services.impl;

import com.magneto.magneto.model.Stats;
import com.magneto.magneto.persistence.entities.DnaEntity;
import com.magneto.magneto.persistence.repositories.DnaRepository;
import com.magneto.magneto.services.IDnaService;
import com.magneto.magneto.services.IStatsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatsService implements IStatsService {

    private IDnaService dnaService;

    public StatsService(IDnaService dnaService) {
        this.dnaService = dnaService;
    }

    public Stats getStats() {
        List<DnaEntity> result = dnaService.getDna();
        Stats stats = new Stats();
        long countMutant = countPersons(result, true);
        long countHuman = countPersons(result, false);
        stats.setCountMutantDna(countMutant);
        stats.setCountHumanDna(countHuman);
        if(countHuman > 0) {
            stats.setRatio(countMutant / countHuman);
        }
        return stats;
    }

    private long countPersons(List<DnaEntity> result, boolean isMutant) {
        return result.stream().filter(x -> x.getIsMutant() == isMutant).count();
    }

}

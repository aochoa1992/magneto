package com.magneto.magneto.services.impl;

import com.magneto.magneto.persistence.entities.DnaEntity;
import com.magneto.magneto.persistence.repositories.DnaRepository;
import com.magneto.magneto.services.IDnaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DnaService implements IDnaService {

    private DnaRepository dnaRepository;

    @Autowired
    public DnaService(DnaRepository dnaRepository) {
        this.dnaRepository = dnaRepository;
    }

    public DnaEntity saveDNA(List<String> dna, boolean isMutant) {
        DnaEntity dnaEntity = new DnaEntity();
        dnaEntity.setSequence(dna.toString());
        dnaEntity.setIsMutant(isMutant);
        return dnaRepository.save(dnaEntity);
    }

    public List<DnaEntity> getDna() {
        return dnaRepository.findAll();
    }
}

package com.magneto.magneto.services;

import com.magneto.magneto.persistence.entities.DnaEntity;

import java.util.List;

public interface IDnaService {
    DnaEntity saveDNA(List<String> den, boolean isMutant);
    List<DnaEntity> getDna();
}

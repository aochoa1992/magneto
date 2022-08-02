package com.magneto.magneto.persistence.repositories;

import com.magneto.magneto.persistence.entities.DnaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DnaRepository extends JpaRepository<DnaEntity, Long> {
}

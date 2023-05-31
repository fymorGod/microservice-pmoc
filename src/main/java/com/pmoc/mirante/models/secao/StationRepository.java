package com.pmoc.mirante.models.secao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StationRepository extends JpaRepository<StationModel, UUID> {
    boolean existsByStation(String nome);
}

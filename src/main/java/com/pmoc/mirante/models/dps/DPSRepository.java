package com.pmoc.mirante.models.dps;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DPSRepository extends JpaRepository<DPSModel, UUID> {
}

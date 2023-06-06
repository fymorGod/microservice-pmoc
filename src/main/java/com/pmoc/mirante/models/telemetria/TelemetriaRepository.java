package com.pmoc.mirante.models.telemetria;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TelemetriaRepository extends JpaRepository<TelemetriaModel, UUID> {
}

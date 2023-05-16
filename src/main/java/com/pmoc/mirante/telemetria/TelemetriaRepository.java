package com.pmoc.mirante.telemetria;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TelemetriaRepository extends JpaRepository<Telemetria, Long> {
    List<Telemetria> findAllByActiveTrue();
}

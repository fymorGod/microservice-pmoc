package com.pmoc.mirante.dps;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DPSRepository extends JpaRepository<DPS, Long> {
    List<DPS> findAllByActiveTrue();
}

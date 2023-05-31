package com.pmoc.mirante.models.antena;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AntenaRepository extends JpaRepository<Antena, Long> {
    List<Antena> findAllByActiveTrue();
}

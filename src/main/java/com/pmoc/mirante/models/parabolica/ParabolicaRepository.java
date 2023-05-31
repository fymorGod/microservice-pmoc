package com.pmoc.mirante.models.parabolica;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParabolicaRepository extends JpaRepository<Parabolica, Long> {
    List<Parabolica> findAllByActiveTrue();
}

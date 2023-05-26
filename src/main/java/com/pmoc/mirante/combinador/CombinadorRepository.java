package com.pmoc.mirante.combinador;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CombinadorRepository extends JpaRepository<Combinador, Long> {
    List<Combinador> findAllByActiveTrue();
}

package com.pmoc.mirante.models.exaustor;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExaustorRepository extends JpaRepository<Exaustor, Long> {
    List<Exaustor> findAllByActiveTrue();
}

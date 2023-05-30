package com.pmoc.mirante.receptor;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReceptorRepository extends JpaRepository<Receptor, Long> {
    List<Receptor> findAllByActiveTrue();
}
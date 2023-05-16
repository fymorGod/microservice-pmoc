package com.pmoc.mirante.nobreak;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NobreakRepository extends JpaRepository<Nobreak, Long> {
    List<Nobreak> findAllByActiveTrue();
}

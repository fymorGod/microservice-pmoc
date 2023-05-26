package com.pmoc.mirante.cabo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CaboRepository extends JpaRepository<Cabo, Long> {
    List<Cabo> findAllByActiveTrue();
}

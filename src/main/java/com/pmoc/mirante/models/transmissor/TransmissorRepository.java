package com.pmoc.mirante.models.transmissor;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransmissorRepository extends JpaRepository<Transmissor, Long> {
    List<Transmissor> findAllByActiveTrue();
}

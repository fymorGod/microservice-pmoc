package com.pmoc.mirante.models.arcondicionado;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArCondicionadoRepository extends JpaRepository<ArCondicionado, Long> {
    List<ArCondicionado> findAllByActiveTrue();
}

package com.pmoc.mirante.models.arcondicionado;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ArCondicionadoRepository extends JpaRepository<ArCondicionado, UUID> {
}

package com.pmoc.mirante.models.receptor;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ReceptorRepository extends JpaRepository<ReceptorModel, UUID> {
}

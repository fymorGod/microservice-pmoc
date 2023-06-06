package com.pmoc.mirante.models.exaustor;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ExaustorRepository extends JpaRepository<ExaustorModel, UUID> {
}

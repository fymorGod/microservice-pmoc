package com.pmoc.mirante.models.disjuntor;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DisjuntorRepository extends JpaRepository<DisjuntorModel, UUID> {
}

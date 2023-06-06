package com.pmoc.mirante.models.nobreak;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface NobreakRepository extends JpaRepository<NobreakModel, UUID> {
}

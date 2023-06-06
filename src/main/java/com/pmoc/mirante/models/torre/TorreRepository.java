package com.pmoc.mirante.models.torre;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TorreRepository extends JpaRepository<TorreModel, UUID> {
}

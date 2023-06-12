package com.pmoc.mirante.models.transmissor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface TransmissorRepository extends JpaRepository<TransmissorModel, UUID> {
}

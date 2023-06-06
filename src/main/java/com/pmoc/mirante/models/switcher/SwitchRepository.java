package com.pmoc.mirante.models.switcher;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SwitchRepository extends JpaRepository<SwitcherModel, UUID> {
}

package com.pmoc.mirante.models.switcher;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SwitchRepository extends JpaRepository<Switcher, Long> {
    List<Switcher>findAllByActiveTrue();
}

package com.pmoc.mirante.models.torre;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TorreRepository extends JpaRepository<Torre, Long> {
    List<Torre> findAllByActiveTrue();
}

package com.pmoc.mirante.models.disjuntor;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DisjuntorRepository extends JpaRepository<Disjuntor, Long> {
    List<Disjuntor> findAllByActiveTrue();
}

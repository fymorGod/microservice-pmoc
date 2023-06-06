package com.pmoc.mirante.services;

import com.pmoc.mirante.models.parabolica.Parabolica;
import com.pmoc.mirante.models.parabolica.ParabolicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ParabolicaService {
    @Autowired
    private ParabolicaRepository repository;

    @Transactional
    public Parabolica save(Parabolica parabolica) {
        return repository.save(parabolica);
    }
    public List<Parabolica> findAll() {
        return repository.findAll();
    }
    public Optional<Parabolica> findById(UUID id) {
        return repository.findById(id);
    }
    @Transactional
    public void delete(Parabolica parabolica) {
        repository.delete(parabolica);
    }
}

package com.pmoc.mirante.services;

import com.pmoc.mirante.models.torre.TorreModel;
import com.pmoc.mirante.models.torre.TorreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TorreService {
    @Autowired
    private TorreRepository repository;

    @Transactional
    public TorreModel save(TorreModel torreModel) {
        return repository.save(torreModel);
    }
    public List<TorreModel> findAll() {
        return repository.findAll();
    }
    public Optional<TorreModel> findById(UUID id) {
        return repository.findById(id);
    }
    @Transactional
    public void delete(TorreModel torreModel) {
        repository.delete(torreModel);
    }
}

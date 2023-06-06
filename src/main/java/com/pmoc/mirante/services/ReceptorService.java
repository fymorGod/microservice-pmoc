package com.pmoc.mirante.services;

import com.pmoc.mirante.models.receptor.ReceptorModel;
import com.pmoc.mirante.models.receptor.ReceptorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ReceptorService {
    @Autowired
    private ReceptorRepository repository;

    @Transactional
    public ReceptorModel save(ReceptorModel receptorModel) {
        return repository.save(receptorModel);
    }
    public List<ReceptorModel> findAll() {
        return repository.findAll();
    }
    public Optional<ReceptorModel> findById(UUID id) {
        return repository.findById(id);
    }
    @Transactional
    public void delete(ReceptorModel receptorModel) {
        repository.delete(receptorModel);
    }
}

package com.pmoc.mirante.services;

import com.pmoc.mirante.models.exaustor.ExaustorModel;
import com.pmoc.mirante.models.exaustor.ExaustorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ExaustorService {

    @Autowired
    private ExaustorRepository repository;
    @Transactional
    public ExaustorModel save(ExaustorModel exaustorModel) {
        return repository.save(exaustorModel);
    }
    public List<ExaustorModel> findAll() {
        return repository.findAll();
    }
    public Optional<ExaustorModel> findById(UUID id) {
        return repository.findById(id);
    }
    @Transactional
    public void delete(ExaustorModel exaustorModel) {
        repository.delete(exaustorModel);
    }


}

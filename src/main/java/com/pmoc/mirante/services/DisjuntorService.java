package com.pmoc.mirante.services;

import com.pmoc.mirante.models.disjuntor.DisjuntorModel;
import com.pmoc.mirante.models.disjuntor.DisjuntorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DisjuntorService {
    @Autowired
    private DisjuntorRepository repository;

    @Transactional
    public DisjuntorModel save(DisjuntorModel disjuntorModel) {
        return repository.save(disjuntorModel);
    }
    public List<DisjuntorModel> findAll(){
        return repository.findAll();
    }
    public Optional<DisjuntorModel> findById(UUID id) {
        return repository.findById(id);
    }

    @Transactional
    public void delete(DisjuntorModel disjuntorModel) {
        repository.delete(disjuntorModel);
    }
}

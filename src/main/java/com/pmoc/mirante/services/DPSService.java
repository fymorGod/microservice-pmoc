package com.pmoc.mirante.services;

import com.pmoc.mirante.models.dps.DPSModel;
import com.pmoc.mirante.models.dps.DPSRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DPSService {
    @Autowired
    private DPSRepository repository;

    @Transactional
    public DPSModel save(DPSModel dpsModel) {
        return repository.save(dpsModel);
    }
    public List<DPSModel> findAll() {
        return repository.findAll();
    }
    public Optional<DPSModel> findById(UUID id) {
        return repository.findById(id);
    }
    @Transactional
    public void delete(DPSModel dpsModel) {
        repository.delete(dpsModel);
    }
}

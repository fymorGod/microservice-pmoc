package com.pmoc.mirante.services;

import com.pmoc.mirante.models.transmissor.TransmissorModel;
import com.pmoc.mirante.models.transmissor.TransmissorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TransmissorService {
    @Autowired
    private TransmissorRepository repository;

    @Transactional
    public TransmissorModel save(TransmissorModel transmissorModel) {
        return repository.save(transmissorModel);
    }
    public List<TransmissorModel> findAll() {
        return repository.findAll();
    }
    public Optional<TransmissorModel> findById(UUID id) {
        return repository.findById(id);
    }
    @Transactional
    public void delete(TransmissorModel transmissorModel) {
        repository.delete(transmissorModel);
    }
}

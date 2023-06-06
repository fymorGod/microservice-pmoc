package com.pmoc.mirante.services;

import com.pmoc.mirante.models.telemetria.TelemetriaModel;
import com.pmoc.mirante.models.telemetria.TelemetriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TelemetriaService {
    @Autowired
    private TelemetriaRepository repository;

    @Transactional
    public TelemetriaModel save(TelemetriaModel telemetriaModel) {
        return repository.save(telemetriaModel);
    }
    public List<TelemetriaModel> findAll() {
        return repository.findAll();
    }
    public Optional<TelemetriaModel> findById(UUID id) {
        return repository.findById(id);
    }
    @Transactional
    public void delete(TelemetriaModel telemetriaModel) {
        repository.delete(telemetriaModel);
    }
}

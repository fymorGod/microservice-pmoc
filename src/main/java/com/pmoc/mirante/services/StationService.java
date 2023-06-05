package com.pmoc.mirante.services;

import com.pmoc.mirante.models.station.StationModel;
import com.pmoc.mirante.models.station.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StationService {

    @Autowired
    private StationRepository repository;

    @Transactional
    public StationModel save(StationModel sectionModel) {
        return repository.save(sectionModel);
    }
    public boolean existsByStation(String nome) {
        return repository.existsByStation(nome);
    }
    public List<StationModel> findAll() {
        return repository.findAll();
    }
    public Optional<StationModel> findById(UUID id) {
        return repository.findById(id);
    }
    @Transactional
    public void delete(StationModel stationModel) {
        repository.delete(stationModel);
    }
}

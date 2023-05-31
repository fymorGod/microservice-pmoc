package com.pmoc.mirante.services;

import com.pmoc.mirante.models.secao.StationModel;
import com.pmoc.mirante.models.secao.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
}

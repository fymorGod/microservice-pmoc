package com.pmoc.mirante.services;

import com.pmoc.mirante.models.antena.AntenaModel;
import com.pmoc.mirante.models.antena.AntenaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AntenaService {

    @Autowired
    private AntenaRepository antenaRepository;

    @Transactional
    public AntenaModel save(AntenaModel antenaModel) {
        return antenaRepository.save(antenaModel);
    }
    public List<AntenaModel> findAll() {
        return antenaRepository.findAll();
    }
    public Optional<AntenaModel> findById(UUID id) {
        return antenaRepository.findById(id);
    }

    @Transactional
    public void delete(AntenaModel antenaModel) {
        antenaRepository.delete(antenaModel);
    }
}

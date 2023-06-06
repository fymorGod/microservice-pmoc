package com.pmoc.mirante.services;

import com.pmoc.mirante.models.combinador.CombinadorModel;
import com.pmoc.mirante.models.combinador.CombinadorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CombinadorService {

    @Autowired
    private CombinadorRepository combinadorRepository;

    @Transactional
    public CombinadorModel save(CombinadorModel combinadorModel){
        return combinadorRepository.save(combinadorModel);
    }
    public List<CombinadorModel> findAll() {
        return combinadorRepository.findAll();
    }
    public Optional<CombinadorModel> findById(UUID id) {
        return combinadorRepository.findById(id);
    }

    @Transactional
    public void delete(CombinadorModel combinadorModel) {
        combinadorRepository.delete(combinadorModel);
    }
}

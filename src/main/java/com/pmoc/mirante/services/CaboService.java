package com.pmoc.mirante.services;

import com.pmoc.mirante.models.cabo.CaboModel;
import com.pmoc.mirante.models.cabo.CaboRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CaboService {
    @Autowired
    private CaboRepository caboRepository;

    @Transactional
    public CaboModel save(CaboModel caboModel) {
        return caboRepository.save(caboModel);
    }
    public List<CaboModel> findAll() {
        return caboRepository.findAll();
    }
    public Optional<CaboModel> findById(UUID id) {
        return caboRepository.findById(id);
    }

    @Transactional
    public void delete(CaboModel caboModel) {
        caboRepository.delete(caboModel);
    }
}

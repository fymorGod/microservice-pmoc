package com.pmoc.mirante.services;

import com.pmoc.mirante.models.switcher.SwitchRepository;
import com.pmoc.mirante.models.switcher.SwitcherModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SwitchService {
    @Autowired
    private SwitchRepository repository;

    @Transactional
    public SwitcherModel save(SwitcherModel switcherModel) {
        return repository.save(switcherModel);
    }
    public List<SwitcherModel> findAll() {
        return repository.findAll();
    }
    public Optional<SwitcherModel> findById(UUID id) {
        return repository.findById(id);
    }
    @Transactional
    public void delete(SwitcherModel switcherModel) {
        repository.delete(switcherModel);
    }
}

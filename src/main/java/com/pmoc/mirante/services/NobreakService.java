package com.pmoc.mirante.services;

import com.pmoc.mirante.models.nobreak.NobreakModel;
import com.pmoc.mirante.models.nobreak.NobreakRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class NobreakService {

    @Autowired
    private NobreakRepository repository;

    @Transactional
    public NobreakModel save(NobreakModel nobreakModel){
        return repository.save(nobreakModel);
    }
    public List<NobreakModel> findAll(){
        return repository.findAll();
    }
    public Optional<NobreakModel> findById(UUID id){
        return repository.findById(id);
    }
    @Transactional
    public void delete(NobreakModel nobreakModel){
        repository.delete(nobreakModel);
    }
}

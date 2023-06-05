package com.pmoc.mirante.services;

import com.pmoc.mirante.models.arcondicionado.ArCondicionado;
import com.pmoc.mirante.models.arcondicionado.ArCondicionadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ArcondicionadoService {

    @Autowired
    private ArCondicionadoRepository repository;

    @Transactional
    public ArCondicionado save(ArCondicionado arCondicionado) {
        return repository.save(arCondicionado);
    }
    public List<ArCondicionado> findAll() {
        return repository.findAll();
    }
    public Optional<ArCondicionado> findById(UUID id) {
        return repository.findById(id);
    }
    @Transactional
    public void delete(ArCondicionado arCondicionado){
        repository.delete(arCondicionado);
    }

}

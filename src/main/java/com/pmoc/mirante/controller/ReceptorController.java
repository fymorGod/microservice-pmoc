package com.pmoc.mirante.controller;


import com.pmoc.mirante.dtos.ReceptorDTO;
import com.pmoc.mirante.models.receptor.DataListingReceptor;
import com.pmoc.mirante.models.receptor.DataUpdatingReceptor;
import com.pmoc.mirante.models.receptor.Receptor;
import com.pmoc.mirante.models.receptor.ReceptorRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("antenas")
public class ReceptorController {
    @Autowired
    private ReceptorRepository repository;

    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid ReceptorDTO data) {
        repository.save(new Receptor(data));
    }
    @GetMapping
    public List<DataListingReceptor> getAllReceptores() {
        return repository.findAllByActiveTrue().stream().map(DataListingReceptor::new).toList();
    }
    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DataUpdatingReceptor dados) {
        var receptor = repository.getReferenceById(dados.id());
        receptor.updateInfo(dados);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id) {
        var receptor = repository.getReferenceById(id);
        receptor.delete();
    }
}

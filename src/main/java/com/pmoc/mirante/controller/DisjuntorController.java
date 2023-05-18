package com.pmoc.mirante.controller;

import com.pmoc.mirante.disjuntor.DataListingDisjuntor;
import com.pmoc.mirante.disjuntor.DataUpdatingDisjuntor;
import com.pmoc.mirante.disjuntor.Disjuntor;
import com.pmoc.mirante.disjuntor.DisjuntorRepository;
import com.pmoc.mirante.dtos.DisjuntorDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("disjuntores")
public class DisjuntorController {

    @Autowired
    private DisjuntorRepository repository;

    @PostMapping
    @Transactional
    public void register(DisjuntorDTO disjuntorDTO){
        repository.save(new Disjuntor(disjuntorDTO));
    }
    @GetMapping
    public List<DataListingDisjuntor> getAllDisjuntores() {
        return repository.findAllByActiveTrue().stream().map(DataListingDisjuntor::new).toList();
    }
    @PutMapping
    @jakarta.transaction.Transactional
    public void atualizar(@RequestBody @Valid DataUpdatingDisjuntor dados) {
        var disjuntor = repository.getReferenceById(dados.id());
        disjuntor.updateInfo(dados);
    }
    @DeleteMapping("/{id}")
    @jakarta.transaction.Transactional
    public void delete(@PathVariable Long id) {
        var disjuntor = repository.getReferenceById(id);
        disjuntor.delete();
    }
}

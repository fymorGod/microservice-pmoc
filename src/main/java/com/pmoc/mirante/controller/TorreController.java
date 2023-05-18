package com.pmoc.mirante.controller;

import com.pmoc.mirante.arcondicionado.DataListingArCondicionados;
import com.pmoc.mirante.dtos.TorreDTO;
import com.pmoc.mirante.torre.DataListingTorre;
import com.pmoc.mirante.torre.DataUpdatingTorre;
import com.pmoc.mirante.torre.Torre;
import com.pmoc.mirante.torre.TorreRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("torres")
public class TorreController {

    @Autowired
    private TorreRepository repository;

    @PostMapping
    @jakarta.transaction.Transactional
    public void register(@RequestBody @Valid TorreDTO data) {
        repository.save(new Torre(data));
    }
    @GetMapping
    public List<DataListingTorre> getAllArCondicionados() {
        return repository.findAllByActiveTrue().stream().map(DataListingTorre::new).toList();
    }
    @PutMapping
    @jakarta.transaction.Transactional
    public void atualizar(@RequestBody @Valid DataUpdatingTorre dados) {
        var torre = repository.getReferenceById(dados.id());
        torre.updateInfo(dados);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id) {
        var torre = repository.getReferenceById(id);
        torre.delete();
    }
}

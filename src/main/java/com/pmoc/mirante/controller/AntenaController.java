package com.pmoc.mirante.controller;

import com.pmoc.mirante.models.antena.Antena;
import com.pmoc.mirante.models.antena.AntenaRepository;
import com.pmoc.mirante.models.antena.DataListingAntena;
import com.pmoc.mirante.models.antena.DataUpdatingAntena;
import com.pmoc.mirante.dtos.AntenaDTO;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("antenas")
public class AntenaController {

    @Autowired
    private AntenaRepository repository;

    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid AntenaDTO data) {
        repository.save(new Antena(data));
    }
    @GetMapping
    public List<DataListingAntena> getAllAntenas() {
        return repository.findAllByActiveTrue().stream().map(DataListingAntena::new).toList();
    }
    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DataUpdatingAntena dados) {
        var antena = repository.getReferenceById(dados.id());
        antena.updateInfo(dados);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id) {
        var antena = repository.getReferenceById(id);
        antena.delete();
    }
}

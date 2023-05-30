package com.pmoc.mirante.controller;

import com.pmoc.mirante.dtos.ParabolicaDTO;
import com.pmoc.mirante.parabolica.DataParabolicaListing;
import com.pmoc.mirante.parabolica.DataUpdatingParabolica;
import com.pmoc.mirante.parabolica.Parabolica;
import com.pmoc.mirante.parabolica.ParabolicaRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("parabolicas")
public class ParabolicaController {
    @Autowired
    private ParabolicaRepository repository;

    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid ParabolicaDTO data) {
        repository.save(new Parabolica(data));
    }
    @GetMapping
    public List<DataParabolicaListing> getAllParabolicas() {
        return repository.findAllByActiveTrue().stream().map(DataParabolicaListing::new).toList();
    }
    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DataUpdatingParabolica dados) {
        var parabolica = repository.getReferenceById(dados.id());
        parabolica.updateInfo(dados);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id) {
        var parabolica = repository.getReferenceById(id);
        parabolica.delete();
    }
}

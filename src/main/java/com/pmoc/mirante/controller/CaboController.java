package com.pmoc.mirante.controller;

import com.pmoc.mirante.models.cabo.Cabo;
import com.pmoc.mirante.models.cabo.CaboRepository;
import com.pmoc.mirante.models.cabo.DataListingCabo;
import com.pmoc.mirante.models.cabo.DataUpdatingCabo;
import com.pmoc.mirante.dtos.CaboDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("cabos")
public class CaboController {
    @Autowired
    private CaboRepository repository;
    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid CaboDTO caboDTO) {
        repository.save(new Cabo(caboDTO));
    }
    @GetMapping
    public List<DataListingCabo> getAllCabos() {
        return repository.findAllByActiveTrue().stream().map(DataListingCabo::new).toList();
    }
    @PutMapping
    @Transactional
    public void updateExaustor(@RequestBody @Valid DataUpdatingCabo data) {
        var cabo = repository.getReferenceById(data.id());
        cabo.updateInfo(data);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable(value = "id") Long id) {
        var cabo = repository.getReferenceById(id);
        cabo.delete();
    }
}

package com.pmoc.mirante.controller;

import com.pmoc.mirante.dtos.ExaustorDTO;
import com.pmoc.mirante.models.exaustor.DataListingExaustor;
import com.pmoc.mirante.models.exaustor.DataUpdatingExaustor;
import com.pmoc.mirante.models.exaustor.Exaustor;
import com.pmoc.mirante.models.exaustor.ExaustorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("exaustores")
public class ExaustorController {
    @Autowired
    private ExaustorRepository exaustorRepository;
    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid ExaustorDTO exaustorDTO) {
        exaustorRepository.save(new Exaustor(exaustorDTO));
    }
    @GetMapping
    public List<DataListingExaustor> getAllExaustores() {
        return exaustorRepository.findAllByActiveTrue().stream().map(DataListingExaustor::new).toList();
    }
    @PutMapping
    @Transactional
    public void updateExaustor(@RequestBody @Valid DataUpdatingExaustor data) {
        var exaustor = exaustorRepository.getReferenceById(data.id());
        exaustor.updateInfo(data);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable(value = "id") Long id) {
        var exaustor = exaustorRepository.getReferenceById(id);
        exaustor.delete();
    }
}

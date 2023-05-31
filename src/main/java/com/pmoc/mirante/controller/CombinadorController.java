package com.pmoc.mirante.controller;

import com.pmoc.mirante.models.combinador.Combinador;
import com.pmoc.mirante.models.combinador.CombinadorRepository;
import com.pmoc.mirante.models.combinador.DataListingCombinador;
import com.pmoc.mirante.models.combinador.DataUpdatingCombinador;
import com.pmoc.mirante.dtos.CombinadorDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("combinadores")
public class CombinadorController {
    @Autowired
    private CombinadorRepository repository;

    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid CombinadorDTO combinadorDTO) {
        repository.save(new Combinador(combinadorDTO));
    }
    @GetMapping
    public List<DataListingCombinador> getAllCombinadores() {
        return repository.findAllByActiveTrue().stream().map(DataListingCombinador::new).toList();
    }
    @PutMapping
    @Transactional
    public void updateExaustor(@RequestBody @Valid DataUpdatingCombinador data) {
        var combinador = repository.getReferenceById(data.id());
        combinador.updateInfo(data);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable(value = "id") Long id) {
        var combinador = repository.getReferenceById(id);
        combinador.delete();
    }
}

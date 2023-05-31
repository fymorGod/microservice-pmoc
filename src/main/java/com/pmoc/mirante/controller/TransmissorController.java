package com.pmoc.mirante.controller;

import com.pmoc.mirante.dtos.TransmissorDTO;
import com.pmoc.mirante.models.transmissor.DadosListingTransmissor;
import com.pmoc.mirante.models.transmissor.DadosUpdatingTransmissor;
import com.pmoc.mirante.models.transmissor.Transmissor;
import com.pmoc.mirante.models.transmissor.TransmissorRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("transmissores")
public class TransmissorController {
    @Autowired
    private TransmissorRepository repository;

    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid TransmissorDTO data) {
        repository.save(new Transmissor(data));
    }
    @GetMapping
    public List<DadosListingTransmissor> getAllTransmissores() {
        return repository.findAllByActiveTrue().stream().map(DadosListingTransmissor::new).toList();
    }
    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosUpdatingTransmissor dados) {
        var transmissor = repository.getReferenceById(dados.id());
        transmissor.updateInfo(dados);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id) {
        var transmissor = repository.getReferenceById(id);
        transmissor.delete();
    }
}

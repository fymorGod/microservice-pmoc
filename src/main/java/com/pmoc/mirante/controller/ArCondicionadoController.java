package com.pmoc.mirante.controller;

import com.pmoc.mirante.arcondicionado.ArCondicionado;
import com.pmoc.mirante.arcondicionado.ArCondicionadoRepository;
import com.pmoc.mirante.arcondicionado.DataListingArCondicionados;
import com.pmoc.mirante.arcondicionado.DataUpdatingArCondicionados;
import com.pmoc.mirante.dtos.ArCondicionadoDTO;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("arcondicionados")
public class ArCondicionadoController {
    @Autowired
    private ArCondicionadoRepository arCondicionadoRepository;
    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid ArCondicionadoDTO data) {
        arCondicionadoRepository.save(new ArCondicionado(data));
    }
    @GetMapping
    public List<DataListingArCondicionados> getAllArCondicionados() {
        return arCondicionadoRepository.findAllByActiveTrue().stream().map(DataListingArCondicionados::new).toList();
    }
    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DataUpdatingArCondicionados dados) {
        var arCondicionado = arCondicionadoRepository.getReferenceById(dados.id());
        arCondicionado.updateInfo(dados);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id) {
        var arCondicionado = arCondicionadoRepository.getReferenceById(id);
        arCondicionado.delete();
    }
}

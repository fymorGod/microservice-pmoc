package com.pmoc.mirante.controller;

import com.pmoc.mirante.models.dps.DPS;
import com.pmoc.mirante.models.dps.DPSRepository;
import com.pmoc.mirante.models.dps.DataListingDPS;
import com.pmoc.mirante.models.dps.DataUpdatingDPS;
import com.pmoc.mirante.dtos.DPSDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class DPSController {
    @Autowired
    private DPSRepository repository;
    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid DPSDTO dpsdto) {
        repository.save(new DPS(dpsdto));
    }
    @GetMapping
    public List<DataListingDPS> getAllDPS() {
        return repository.findAllByActiveTrue().stream().map(DataListingDPS::new).toList();
    }
    @PutMapping
    @Transactional
    public void updateExaustor(@RequestBody @Valid DataUpdatingDPS data) {
        var dps = repository.getReferenceById(data.id());
        dps.updateInfo(data);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable(value = "id") Long id) {
        var dps = repository.getReferenceById(id);
        dps.delete();
    }
}

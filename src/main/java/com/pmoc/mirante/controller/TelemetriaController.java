package com.pmoc.mirante.controller;

import com.pmoc.mirante.dtos.TelemetriaDTO;
import com.pmoc.mirante.telemetria.DataListingTelemetria;
import com.pmoc.mirante.telemetria.DataUpdatingTelemetria;
import com.pmoc.mirante.telemetria.Telemetria;
import com.pmoc.mirante.telemetria.TelemetriaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("telemetria")
public class TelemetriaController {
    @Autowired
    private TelemetriaRepository telemetriaRepository;

    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid TelemetriaDTO telemetriaDTO) {
        telemetriaRepository.save(new Telemetria(telemetriaDTO));
    }
    @GetMapping
    public List<DataListingTelemetria> getAllTelemetrias() {
        return telemetriaRepository.findAllByActiveTrue().stream().map(DataListingTelemetria::new).toList();
    }
    @PutMapping
    @Transactional
    public void updateTelemetria(@RequestBody @Valid DataUpdatingTelemetria data) {
        var telemetria = telemetriaRepository.getReferenceById(data.id());
        telemetria.updateInfo(data);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable(value = "id") Long id){
        var telemetria = telemetriaRepository.getReferenceById(id);
        telemetria.delete();
    }
}

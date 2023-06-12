package com.pmoc.mirante.controller;

import com.pmoc.mirante.dtos.TelemetriaDTO;
import com.pmoc.mirante.models.telemetria.TelemetriaModel;
import com.pmoc.mirante.services.TelemetriaService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/telemetria")
public class TelemetriaController {
    @Autowired
    private TelemetriaService telemetriaService;

    @PostMapping
    public ResponseEntity<Object> saveTelemetria(@RequestBody @Valid TelemetriaDTO telemetriaDTO) {
        var telemetriaModel = new TelemetriaModel();
        BeanUtils.copyProperties(telemetriaDTO, telemetriaModel);
        telemetriaModel.setCreatedAt(LocalDateTime.now(ZoneId.of("UFC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(telemetriaService.save(telemetriaModel));
    }

    @GetMapping
    public ResponseEntity<List<TelemetriaModel>> gettAllTelemetria() {
        return ResponseEntity.status(HttpStatus.OK).body(telemetriaService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneTelemetria(@PathVariable(value = "id") UUID id) {
        Optional<TelemetriaModel> telemetriaModelOptional = telemetriaService.findById(id);
        if(!telemetriaModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Station not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(telemetriaModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTelemetria(@PathVariable(value = "id") UUID id){
        Optional<TelemetriaModel> telemetriaModelOptional = telemetriaService.findById(id);
        if(!telemetriaModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Station not found");
        }
        telemetriaService.delete(telemetriaModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Station deleted Successfully.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateTelemetria(@PathVariable(value = "id") UUID id, @RequestBody @Valid TelemetriaDTO telemetriaDTO) {
        Optional<TelemetriaModel> telemetriaModelOptional = telemetriaService.findById(id);
        if(!telemetriaModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Station not found");
        }
        var telemetriaModel = new TelemetriaModel();
        BeanUtils.copyProperties(telemetriaDTO, telemetriaModel);
        telemetriaModel.setId(telemetriaModelOptional.get().getId());
        telemetriaModel.setUpdatedAt(LocalDateTime.now(ZoneId.of("UFC")));
        return ResponseEntity.status(HttpStatus.OK).body(telemetriaService.save(telemetriaModel));
    }
}

package com.pmoc.mirante.controller;

import com.pmoc.mirante.dtos.ParabolicaDTO;
import com.pmoc.mirante.dtos.StationDTO;
import com.pmoc.mirante.models.parabolica.Parabolica;
import com.pmoc.mirante.models.parabolica.ParabolicaRepository;
import com.pmoc.mirante.models.station.StationModel;
import com.pmoc.mirante.services.ParabolicaService;
import com.pmoc.mirante.services.StationService;
import jakarta.transaction.Transactional;
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
@RequestMapping("/parabolica")
public class ParabolicaController {
    @Autowired
    private ParabolicaService parabolicaService;

    @PostMapping
    public ResponseEntity<Object> saveParabolica(@RequestBody @Valid ParabolicaDTO parabolicaDTO) {
        var parabolicaModel = new Parabolica();
        BeanUtils.copyProperties(parabolicaDTO, parabolicaModel);
        parabolicaModel.setCreatedAt(LocalDateTime.now(ZoneId.of("UFC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(parabolicaService.save(parabolicaModel));
    }

    @GetMapping
    public ResponseEntity<List<Parabolica>> gettAllParabolica() {
        return ResponseEntity.status(HttpStatus.OK).body(parabolicaService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneParabolica(@PathVariable(value = "id") UUID id) {
        Optional<Parabolica> parabolicaOptional = parabolicaService.findById(id);
        if(!parabolicaOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parabolica not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(parabolicaOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteParabolica(@PathVariable(value = "id") UUID id){
        Optional<Parabolica> parabolicaOptional = parabolicaService.findById(id);
        if(!parabolicaOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parabolica not found");
        }
        parabolicaService.delete(parabolicaOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Station deleted Successfully.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateParabolica(@PathVariable(value = "id") UUID id, @RequestBody @Valid ParabolicaDTO parabolicaDTO) {
        Optional<Parabolica> parabolicaOptional = parabolicaService.findById(id);
        if(!parabolicaOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parabolica not found");
        }
        var parabolicaModel = new Parabolica();
        BeanUtils.copyProperties(parabolicaDTO, parabolicaModel);
        parabolicaModel.setId(parabolicaOptional.get().getId());
        parabolicaModel.setUpdatedAt(LocalDateTime.now(ZoneId.of("UFC")));
        return ResponseEntity.status(HttpStatus.OK).body(parabolicaService.save(parabolicaModel));
    }
}

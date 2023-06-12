package com.pmoc.mirante.controller;

import com.pmoc.mirante.dtos.ExaustorDTO;
import com.pmoc.mirante.dtos.StationDTO;
import com.pmoc.mirante.models.exaustor.ExaustorModel;
import com.pmoc.mirante.models.exaustor.ExaustorRepository;
import com.pmoc.mirante.models.station.StationModel;
import com.pmoc.mirante.services.ExaustorService;
import com.pmoc.mirante.services.StationService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/exaustores")
public class ExaustorController {
    @Autowired
    private ExaustorService exaustorService;

    @PostMapping
    public ResponseEntity<Object> saveExaustor(@RequestBody @Valid ExaustorDTO exaustorDTO) {

        var exaustorModel = new ExaustorModel();
        BeanUtils.copyProperties(exaustorDTO, exaustorModel);
        exaustorModel.setCreatedAt(LocalDateTime.now(ZoneId.of("UFC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(exaustorService.save(exaustorModel));
    }

    @GetMapping
    public ResponseEntity<List<ExaustorModel>> gettAllExaustor() {
        return ResponseEntity.status(HttpStatus.OK).body(exaustorService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneExaustor(@PathVariable(value = "id") UUID id) {
        Optional<ExaustorModel> exaustorModelOptional = exaustorService.findById(id);
        if(!exaustorModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Exaustor not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(exaustorModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteExaustor(@PathVariable(value = "id") UUID id){
        Optional<ExaustorModel> exaustorModelOptional = exaustorService.findById(id);
        if(!exaustorModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Exaustor not found.");
        }
        exaustorService.delete(exaustorModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Station deleted Successfully.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateExaustor(@PathVariable(value = "id") UUID id, @RequestBody @Valid ExaustorDTO exaustorDTO) {
        Optional<ExaustorModel> exaustorModelOptional = exaustorService.findById(id);
        if(!exaustorModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Exaustor not found.");
        }
        var exaustorModel = new ExaustorModel();
        BeanUtils.copyProperties(exaustorDTO, exaustorModel);
        exaustorModel.setId(exaustorModelOptional.get().getId());
        exaustorModel.setUpdatedAt(LocalDateTime.now(ZoneId.of("UFC")));
        return ResponseEntity.status(HttpStatus.OK).body(exaustorService.save(exaustorModel));
    }
}

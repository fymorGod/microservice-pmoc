package com.pmoc.mirante.controller;


import com.pmoc.mirante.dtos.TorreDTO;
import com.pmoc.mirante.models.torre.TorreModel;
import com.pmoc.mirante.services.TorreService;
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
@RequestMapping("/torre")
public class TorreController {
    @Autowired
    private TorreService torreService;

    @PostMapping
    public ResponseEntity<Object> saveTorre(@RequestBody @Valid TorreDTO torreDTO) {

        var torreModel = new TorreModel();
        BeanUtils.copyProperties(torreDTO, torreModel);
        torreModel.setCreatedAt(LocalDateTime.now(ZoneId.of("UFC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(torreService.save(torreModel));
    }

    @GetMapping
    public ResponseEntity<List<TorreModel>> gettAllTorre() {
        return ResponseEntity.status(HttpStatus.OK).body(torreService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneTorre(@PathVariable(value = "id") UUID id) {
        Optional<TorreModel> torreModelOptional = torreService.findById(id);
        if(!torreModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Torre not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(torreModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTorre(@PathVariable(value = "id") UUID id){
        Optional<TorreModel> torreModelOptional = torreService.findById(id);
        if(!torreModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Torre not found");
        }
        torreService.delete(torreModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Torre deleted Successfully.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateTorre(@PathVariable(value = "id") UUID id, @RequestBody @Valid TorreDTO torreDTO) {
        Optional<TorreModel> torreModelOptional = torreService.findById(id);
        if(!torreModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Torre not found");
        }
        var torreModel = new TorreModel();
        BeanUtils.copyProperties(torreDTO, torreModel);
        torreModel.setId(torreModelOptional.get().getId());
        torreModel.setUpdatedAt(LocalDateTime.now(ZoneId.of("UFC")));
        return ResponseEntity.status(HttpStatus.OK).body(torreService.save(torreModel));
    }
}

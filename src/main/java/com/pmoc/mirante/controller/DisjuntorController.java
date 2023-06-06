package com.pmoc.mirante.controller;

import com.pmoc.mirante.models.disjuntor.DisjuntorModel;
import com.pmoc.mirante.dtos.DisjuntorDTO;
import com.pmoc.mirante.services.DisjuntorService;
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
@RequestMapping("/disjuntores")
public class DisjuntorController {

    @Autowired
    private DisjuntorService disjuntorService;

    @PostMapping
    public ResponseEntity<Object> saveDisjuntor(@RequestBody @Valid DisjuntorDTO disjuntorDTO) {
        var disjuntorModel = new DisjuntorModel();
        BeanUtils.copyProperties(disjuntorDTO, disjuntorModel);
        disjuntorModel.setCreatedAt(LocalDateTime.now(ZoneId.of("UFC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(disjuntorService.save(disjuntorModel));
    }
    @GetMapping
    public ResponseEntity<List<DisjuntorModel>> getAllDisjuntor() {
        return ResponseEntity.status(HttpStatus.OK).body(disjuntorService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneDisjuntor(@PathVariable(value = "id") UUID id){
        Optional<DisjuntorModel> disjuntorModelOptional = disjuntorService.findById(id);
        if(!disjuntorModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Disjuntor not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(disjuntorModelOptional.get());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteDisjuntor(@PathVariable(value = "id") UUID id){
        Optional<DisjuntorModel> disjuntorModelOptional = disjuntorService.findById(id);
        if(!disjuntorModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Disjuntor not found");
        }
        disjuntorService.delete(disjuntorModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Disjuntor deleted successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateDisjuntor(@PathVariable(value = "id") UUID id, @RequestBody @Valid DisjuntorDTO disjuntorDTO) {
        Optional<DisjuntorModel> disjuntorModelOptional = disjuntorService.findById(id);
        if(!disjuntorModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Disjuntor not found");
        }
        var disjuntorModel = new DisjuntorModel();
        BeanUtils.copyProperties(disjuntorDTO, disjuntorModel);
        disjuntorModel.setUpdatedAt(LocalDateTime.now(ZoneId.of("UFC")));
        return ResponseEntity.status(HttpStatus.OK).body(disjuntorService.save(disjuntorModel));
    }
}

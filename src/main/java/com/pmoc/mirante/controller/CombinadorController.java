package com.pmoc.mirante.controller;

import com.pmoc.mirante.dtos.CombinadorDTO;
import com.pmoc.mirante.models.combinador.CombinadorModel;
import com.pmoc.mirante.services.CombinadorService;
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
@RequestMapping("/combinadores")
public class CombinadorController {

    @Autowired
    private CombinadorService combinadorService;

    @PostMapping
    public ResponseEntity<Object> saveCombinador(@RequestBody @Valid CombinadorDTO combinadorDTO) {
        var combinadorModel = new CombinadorModel();
        BeanUtils.copyProperties(combinadorDTO, combinadorModel);
        combinadorModel.setCreatedAt(LocalDateTime.now(ZoneId.of("UFC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(combinadorService.save(combinadorModel));
    }

    @GetMapping
    public ResponseEntity<List<CombinadorModel>> getAllCombinador() {
        return ResponseEntity.status(HttpStatus.OK).body(combinadorService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneCombinador(@PathVariable(value = "id") UUID id){
        Optional<CombinadorModel> combinadorModelOptional = combinadorService.findById(id);
        if(!combinadorModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Combinador not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(combinadorModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCombinador(@PathVariable(value = "id") UUID id){
        Optional<CombinadorModel> combinadorModelOptional = combinadorService.findById(id);
        if(!combinadorModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Combinador not found");
        }
        combinadorService.delete(combinadorModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Combinador deleted successfully");
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCombinador(@PathVariable(value = "id") UUID id, @RequestBody @Valid CombinadorDTO combinadorDTO) {
        Optional<CombinadorModel> combinadorModelOptional = combinadorService.findById(id);
        if(!combinadorModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Combinador not found");
        }
        var combinadorModel = new CombinadorModel();
        BeanUtils.copyProperties(combinadorDTO, combinadorModel);
        combinadorModel.setId(combinadorModelOptional.get().getId());
        combinadorModel.setUpdatedAt(LocalDateTime.now(ZoneId.of("UFC")));
        return ResponseEntity.status(HttpStatus.OK).body(combinadorService.save(combinadorModel));
    }
}

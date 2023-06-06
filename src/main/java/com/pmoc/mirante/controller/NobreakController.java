package com.pmoc.mirante.controller;

import com.pmoc.mirante.dtos.NobrekDTO;
import com.pmoc.mirante.models.nobreak.NobreakModel;
import com.pmoc.mirante.models.nobreak.NobreakRepository;
import com.pmoc.mirante.services.NobreakService;
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
@RequestMapping("/nobreaks")
public class NobreakController {

    @Autowired
    private NobreakService nobreakService;

    @PostMapping
    public ResponseEntity<Object> saveNobreak(@RequestBody @Valid NobrekDTO nobrekDTO) {
        var nobreakModel = new NobreakModel();
        BeanUtils.copyProperties(nobrekDTO, nobreakModel);
        nobreakModel.setCreatedAt(LocalDateTime.now(ZoneId.of("UFC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(nobreakService.save(nobreakModel));
    }

    @GetMapping
    public ResponseEntity<List<NobreakModel>> getAllNobreak() {
        return ResponseEntity.status(HttpStatus.OK).body(nobreakService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneNobreak(@PathVariable(value = "id") UUID id) {
        Optional<NobreakModel> nobreakModelOptional = nobreakService.findById(id);
        if(!nobreakModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nobreak not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(nobreakModelOptional.get());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteNobreak(@PathVariable(value = "id") UUID id){
        Optional<NobreakModel> nobreakModelOptional = nobreakService.findById(id);
        if(!nobreakModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nobreak not found");
        }
        nobreakService.delete(nobreakModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Nobreak deleted successfully");
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateNobreak(@PathVariable(value = "id") UUID id, @RequestBody @Valid NobrekDTO nobrekDTO){
        Optional<NobreakModel> nobreakModelOptional = nobreakService.findById(id);
        if(!nobreakModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nobreak not found");
        }
        var nobreakModel = new NobreakModel();
        BeanUtils.copyProperties(nobrekDTO, nobreakModel);
        nobreakModel.setUpdatedAt(LocalDateTime.now(ZoneId.of("UFC")));
        return ResponseEntity.status(HttpStatus.OK).body(nobreakService.save(nobreakModel));
    }
}

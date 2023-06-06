package com.pmoc.mirante.controller;

import com.pmoc.mirante.dtos.AntenaDTO;
import com.pmoc.mirante.models.antena.AntenaModel;
import com.pmoc.mirante.services.AntenaService;
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
@RequestMapping("/antenas")
public class AntenaController {

    @Autowired
    private AntenaService antenaService;

    @PostMapping
    public ResponseEntity<Object> saveAntena(@RequestBody @Valid AntenaDTO antenaDTO) {
        var antenaModel = new AntenaModel();
        BeanUtils.copyProperties(antenaDTO, antenaModel);
        antenaModel.setCreatedAt(LocalDateTime.now(ZoneId.of("UFC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(antenaService.save(antenaModel));
    }

    @GetMapping
    public ResponseEntity<List<AntenaModel>> getAllAntenas() {
        return ResponseEntity.status(HttpStatus.OK).body(antenaService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneAntena(@PathVariable(value = "id") UUID id) {
        Optional<AntenaModel> antenaModelOptional = antenaService.findById(id);
        if(!antenaModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Antena not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(antenaModelOptional.get());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteAntena(@PathVariable(value = "id") UUID id) {
        Optional<AntenaModel> antenaModelOptional = antenaService.findById(id);
        if(!antenaModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("antena not found");
        }
        antenaService.delete(antenaModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Antena deleted successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateAntena(@PathVariable(value = "id") UUID id, @RequestBody @Valid AntenaDTO antenaDTO) {
        Optional<AntenaModel> antenaModelOptional = antenaService.findById(id);
        if(!antenaModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Antena not found");
        }
        var antenaModel = new AntenaModel();
        BeanUtils.copyProperties(antenaDTO, antenaModel);
        antenaModel.setId(antenaModelOptional.get().getId());
        antenaModel.setUpdatedAt(LocalDateTime.now(ZoneId.of("UFC")));
        return ResponseEntity.status(HttpStatus.OK).body(antenaService.save(antenaModel));
    }
}

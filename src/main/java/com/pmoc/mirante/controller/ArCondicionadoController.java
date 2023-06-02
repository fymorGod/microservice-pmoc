package com.pmoc.mirante.controller;

import com.pmoc.mirante.dtos.ArCondicionadoDTO;
import com.pmoc.mirante.models.arcondicionado.ArCondicionado;
import com.pmoc.mirante.services.ArcondicionadoService;
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
@RequestMapping("/arcondicionados")
public class ArCondicionadoController {
    @Autowired
    private ArcondicionadoService arcondicionadoService;

    @PostMapping
    public ResponseEntity<Object> saveArcondicionado(@RequestBody @Valid ArCondicionadoDTO arCondicionadoDTO) {
        var arcondicionadoModel = new ArCondicionado();
        BeanUtils.copyProperties(arCondicionadoDTO, arcondicionadoModel);
        arcondicionadoModel.setCreatedAt(LocalDateTime.now(ZoneId.of("UFC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(arcondicionadoService.save(arcondicionadoModel));
    }

    @GetMapping
    public ResponseEntity<List<ArCondicionado>> getAllArcondicionados() {
        return ResponseEntity.status(HttpStatus.OK).body(arcondicionadoService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneArcondicionado(@PathVariable(value = "id") UUID id) {
        Optional<ArCondicionado> arCondicionadoOptional = arcondicionadoService.findById(id);
        if(!arCondicionadoOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Arcondicionado not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(arCondicionadoOptional.get());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteArcondicionado(@PathVariable(value = "id") UUID id) {
        Optional<ArCondicionado> arCondicionadoOptional = arcondicionadoService.findById(id);
        if(!arCondicionadoOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Arcondicionado not found");
        }
        arcondicionadoService.delete(arCondicionadoOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Arcondicionado deleted successfully");
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateArcondicionado(@PathVariable(value = "id") UUID id, @RequestBody @Valid ArCondicionadoDTO arCondicionadoDTO ){
        Optional<ArCondicionado> arCondicionadoOptional = arcondicionadoService.findById(id);
        if(!arCondicionadoOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Arcondicionado not found");
        }
        var arcondicionadoModel = new ArCondicionado();
        BeanUtils.copyProperties(arCondicionadoDTO, arcondicionadoModel);
        arcondicionadoModel.setId(arCondicionadoOptional.get().getId());
        arcondicionadoModel.setUpdatedAt(LocalDateTime.now(ZoneId.of("UFC")));
        return ResponseEntity.status(HttpStatus.OK).body(arcondicionadoService.save(arcondicionadoModel));
    }
}

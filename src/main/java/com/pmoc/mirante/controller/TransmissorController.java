package com.pmoc.mirante.controller;

import com.pmoc.mirante.dtos.TransmissorDTO;
import com.pmoc.mirante.models.transmissor.TransmissorModel;
import com.pmoc.mirante.services.TransmissorService;
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
@RequestMapping("/transmissor")
public class TransmissorController {
   @Autowired
    private TransmissorService transmissorService;

    @PostMapping
    public ResponseEntity<Object> saveTransmissor(@RequestBody @Valid TransmissorDTO transmissorDTO) {

        var transmissorModel = new TransmissorModel();
        BeanUtils.copyProperties(transmissorDTO, transmissorModel);
        transmissorModel.setCreatedAt(LocalDateTime.now(ZoneId.of("UFC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(transmissorService.save(transmissorModel));
    }

    @GetMapping
    public ResponseEntity<List<TransmissorModel>> gettAllStations() {
        return ResponseEntity.status(HttpStatus.OK).body(transmissorService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneTransmissor(@PathVariable(value = "id") UUID id) {
        Optional<TransmissorModel> transmissorModelOptional = transmissorService.findById(id);
        if(!transmissorModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Transmissor not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(transmissorModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTransmissor(@PathVariable(value = "id") UUID id){
        Optional<TransmissorModel> transmissorModelOptional = transmissorService.findById(id);
        if(!transmissorModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Transmissor not found");
        }
        transmissorService.delete(transmissorModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Transmissor deleted Successfully.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateTransmissor(@PathVariable(value = "id") UUID id, @RequestBody @Valid  TransmissorDTO transmissorDTO) {
        Optional<TransmissorModel> transmissorModelOptional = transmissorService.findById(id);
        if(!transmissorModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Transmissor not found");
        }
        var transmissorModel = new TransmissorModel();
        BeanUtils.copyProperties(transmissorDTO, transmissorModel);
        transmissorModel.setId(transmissorModelOptional.get().getId());
        transmissorModel.setUpdatedAt(LocalDateTime.now(ZoneId.of("UFC")));
        return ResponseEntity.status(HttpStatus.OK).body(transmissorService.save(transmissorModel));
    }
}

package com.pmoc.mirante.controller;

import com.pmoc.mirante.models.dps.DPSModel;
import com.pmoc.mirante.dtos.DPSDTO;
import com.pmoc.mirante.services.DPSService;
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
@RequestMapping("/dps")
public class DPSController {
    @Autowired
    private DPSService dpsService;

    @PostMapping
    public ResponseEntity<Object> saveDPS(@RequestBody @Valid DPSDTO dpsdto) {

        var dpsModel = new DPSModel();
        BeanUtils.copyProperties(dpsdto, dpsModel);
        dpsModel.setCreatedAt(LocalDateTime.now(ZoneId.of("UFC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(dpsService.save(dpsModel));
    }

    @GetMapping
    public ResponseEntity<List<DPSModel>> gettAllDPS() {
        return ResponseEntity.status(HttpStatus.OK).body(dpsService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneDPS(@PathVariable(value = "id") UUID id) {
        Optional<DPSModel> dpsModelOptional = dpsService.findById(id);
        if(!dpsModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("DPS not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(dpsModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteDPS(@PathVariable(value = "id") UUID id){
        Optional<DPSModel> dpsModelOptional = dpsService.findById(id);
        if(!dpsModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("DPS not found.");
        }
        dpsService.delete(dpsModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("DPS deleted Successfully.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateDPS(@PathVariable(value = "id") UUID id, @RequestBody @Valid DPSDTO dpsdto) {
        Optional<DPSModel> dpsModelOptional = dpsService.findById(id);
        if(!dpsModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("DPS not found.");
        }
        var dpsModel = new DPSModel();
        BeanUtils.copyProperties(dpsdto, dpsModel);
        dpsModel.setId(dpsModelOptional.get().getId());
        dpsModel.setUpdatedAt(LocalDateTime.now(ZoneId.of("UFC")));
        return ResponseEntity.status(HttpStatus.OK).body(dpsService.save(dpsModel));
    }
}

package com.pmoc.mirante.controller;


import com.pmoc.mirante.dtos.ReceptorDTO;
import com.pmoc.mirante.dtos.StationDTO;
import com.pmoc.mirante.models.receptor.ReceptorModel;
import com.pmoc.mirante.models.receptor.ReceptorRepository;
import com.pmoc.mirante.models.station.StationModel;
import com.pmoc.mirante.services.ReceptorService;
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
@RequestMapping("/receptor")
public class ReceptorController {
    @Autowired
    private ReceptorService receptorService;

    @PostMapping
    public ResponseEntity<Object> saveReceptor(@RequestBody @Valid StationDTO stationDTO) {
        var receptorModel = new ReceptorModel();
        BeanUtils.copyProperties(stationDTO, receptorModel);
        receptorModel.setCreatedAt(LocalDateTime.now(ZoneId.of("UFC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(receptorService.save(receptorModel));
    }

    @GetMapping
    public ResponseEntity<List<ReceptorModel>> gettAllReceptor() {
        return ResponseEntity.status(HttpStatus.OK).body(receptorService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneReceptor(@PathVariable(value = "id") UUID id) {
        Optional<ReceptorModel> receptorModelOptional = receptorService.findById(id);
        if(!receptorModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Receptor not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(receptorModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteReceptor(@PathVariable(value = "id") UUID id){
        Optional<ReceptorModel> receptorModelOptional = receptorService.findById(id);
        if(!receptorModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Receptor not found");
        }
        receptorService.delete(receptorModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Station deleted Successfully.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateReceptor(@PathVariable(value = "id") UUID id, @RequestBody @Valid StationDTO stationDTO) {
        Optional<ReceptorModel> receptorModelOptional = receptorService.findById(id);
        if(!receptorModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Receptor not found");
        }
        var receptorModel = new ReceptorModel();
        BeanUtils.copyProperties(stationDTO, receptorModel);
        receptorModel.setId(receptorModelOptional.get().getId());
        receptorModel.setUpdatedAt(LocalDateTime.now(ZoneId.of("UFC")));
        return ResponseEntity.status(HttpStatus.OK).body(receptorService.save(receptorModel));
    }
}

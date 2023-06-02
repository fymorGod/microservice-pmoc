package com.pmoc.mirante.controller;

import com.pmoc.mirante.dtos.StationDTO;
import com.pmoc.mirante.models.secao.StationModel;
import com.pmoc.mirante.services.StationService;
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
@RequestMapping("/station")
public class StationController {

    @Autowired
    private StationService stationService;

    @PostMapping
    public ResponseEntity<Object> saveStation(@RequestBody @Valid StationDTO stationDTO) {
        if(stationService.existsByStation(stationDTO.nome())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Station already registered for this name!");
        }
        var stationModel = new StationModel();
        BeanUtils.copyProperties(stationDTO, stationModel);
        stationModel.setCreatedAt(LocalDateTime.now(ZoneId.of("UFC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(stationService.save(stationModel));
    }

    @GetMapping
    public ResponseEntity<List<StationModel>> gettAllStations() {
        return ResponseEntity.status(HttpStatus.OK).body(stationService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneStation(@PathVariable(value = "id") UUID id) {
        Optional<StationModel> stationModelOptional = stationService.findById(id);
        if(!stationModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Station not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(stationModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteStation(@PathVariable(value = "id") UUID id){
        Optional<StationModel> stationModelOptional = stationService.findById(id);
        if(!stationModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Station not found");
        }
        stationService.delete(stationModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Station deleted Successfully.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateStation(@PathVariable(value = "id") UUID id, @RequestBody @Valid StationDTO stationDTO) {
        Optional<StationModel> stationModelOptional = stationService.findById(id);
        if(!stationModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Station not found");
        }
        var stationModel = new StationModel();
        BeanUtils.copyProperties(stationDTO, stationModel);
        stationModel.setId(stationModelOptional.get().getId());
        stationModel.setUpdatedAt(LocalDateTime.now(ZoneId.of("UFC")));
        return ResponseEntity.status(HttpStatus.OK).body(stationService.save(stationModel));
    }

}

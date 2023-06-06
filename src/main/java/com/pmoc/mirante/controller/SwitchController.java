package com.pmoc.mirante.controller;

import com.pmoc.mirante.dtos.StationDTO;
import com.pmoc.mirante.dtos.SwitcherDTO;
import com.pmoc.mirante.models.station.StationModel;
import com.pmoc.mirante.models.switcher.SwitchRepository;
import com.pmoc.mirante.models.switcher.SwitcherModel;
import com.pmoc.mirante.services.SwitchService;
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
@RequestMapping("/switch")
public class SwitchController {

    @Autowired
    private SwitchService switchService;

    @PostMapping
    public ResponseEntity<Object> saveSwitch(@RequestBody @Valid SwitcherDTO switcherDTO) {
        var switcherModel = new SwitcherModel();
        BeanUtils.copyProperties(switcherDTO, switcherModel);
        switcherModel.setCreatedAt(LocalDateTime.now(ZoneId.of("UFC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(switchService.save(switcherModel));
    }

    @GetMapping
    public ResponseEntity<List<SwitcherModel>> gettAllSwitches() {
        return ResponseEntity.status(HttpStatus.OK).body(switchService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneSwitch(@PathVariable(value = "id") UUID id) {
        Optional<SwitcherModel> switcherModelOptional = switchService.findById(id);
        if(!switcherModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Switch not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(switcherModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteSwitches(@PathVariable(value = "id") UUID id){
        Optional<SwitcherModel> switcherModelOptional = switchService.findById(id);
        if(!switcherModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Switch not found");
        }
        switchService.delete(switcherModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Station deleted Successfully.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateSwitch(@PathVariable(value = "id") UUID id, @RequestBody @Valid SwitcherDTO switcherDTO) {
        Optional<SwitcherModel> switcherModelOptional = switchService.findById(id);
        if(!switcherModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Switch not found");
        }
        var switcherModel = new SwitcherModel();
        BeanUtils.copyProperties(switcherDTO, switcherModel);
        switcherModel.setId(switcherModelOptional.get().getId());
        switcherModel.setUpdatedAt(LocalDateTime.now(ZoneId.of("UFC")));
        return ResponseEntity.status(HttpStatus.OK).body(switchService.save(switcherModel));
    }
}

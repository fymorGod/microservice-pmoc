package com.pmoc.mirante.controller;

import com.pmoc.mirante.models.cabo.CaboModel;
import com.pmoc.mirante.dtos.CaboDTO;
import com.pmoc.mirante.services.CaboService;
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
@RequestMapping("/cabos")
public class CaboController {
   @Autowired
   private CaboService caboService;

   @PostMapping
   public ResponseEntity<Object> saveCabo(@RequestBody @Valid CaboDTO caboDTO) {
       var caboModel = new CaboModel();
       BeanUtils.copyProperties(caboDTO, caboModel);
       caboModel.setCreatedAt(LocalDateTime.now(ZoneId.of("UFC")));
       return ResponseEntity.status(HttpStatus.CREATED).body(caboService.save(caboModel));
   }

   @GetMapping
    public ResponseEntity<List<CaboModel>> getAllCabo() {
       return ResponseEntity.status(HttpStatus.OK).body(caboService.findAll());
   }
   @GetMapping("/{id}")
    public ResponseEntity<Object> getOneCabo(@PathVariable(value = "id") UUID id) {
       Optional<CaboModel> caboModelOptional = caboService.findById(id);
       if(!caboModelOptional.isPresent()){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cabo not found");
       }
       return ResponseEntity.status(HttpStatus.OK).body(caboModelOptional.get());
   }
   @DeleteMapping("/{id}")
   public ResponseEntity<Object> updateCabo(@PathVariable(value = "id") UUID id, @RequestBody @Valid CaboDTO caboDTO){
       Optional<CaboModel> caboModelOptional = caboService.findById(id);
       if(!caboModelOptional.isPresent()){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cabo not found");
       }
       var caboModel = new CaboModel();
       BeanUtils.copyProperties(caboDTO, caboModel);
       caboModel.setId(caboModelOptional.get().getId());
       caboModel.setUpdatedAt(LocalDateTime.now(ZoneId.of("UFC")));
       return ResponseEntity.status(HttpStatus.OK).body(caboService.save(caboModel));
   }
}

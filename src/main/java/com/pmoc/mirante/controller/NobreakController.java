package com.pmoc.mirante.controller;

import com.pmoc.mirante.dtos.NobrekDTO;
import com.pmoc.mirante.nobreak.DataListingNobreak;
import com.pmoc.mirante.nobreak.DataUpdatingNobreak;
import com.pmoc.mirante.nobreak.Nobreak;
import com.pmoc.mirante.nobreak.NobreakRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("nobreaks")
public class NobreakController {

    @Autowired
    private NobreakRepository nobreakRepository;
    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid NobrekDTO nobrekDTO) {
        nobreakRepository.save(new Nobreak(nobrekDTO));
    }
    @GetMapping
    public List<DataListingNobreak> getAllNobreak() {
        return nobreakRepository.findAllByActiveTrue().stream().map(DataListingNobreak::new).toList();
    }
    @PutMapping
    @Transactional
    public void updateNobreak(@RequestBody @Valid DataUpdatingNobreak data){
        var nobreak = nobreakRepository.getReferenceById(data.id());
        nobreak.updateInfo(data);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable(value = "id") Long id){
        var nobreak = nobreakRepository.getReferenceById(id);
        nobreak.delete();
    }
}

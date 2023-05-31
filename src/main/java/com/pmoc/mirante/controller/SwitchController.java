package com.pmoc.mirante.controller;

import com.pmoc.mirante.dtos.SwitcherDTO;
import com.pmoc.mirante.models.switcher.DataListingSwitch;
import com.pmoc.mirante.models.switcher.DataUpdatingSwitch;
import com.pmoc.mirante.models.switcher.SwitchRepository;
import com.pmoc.mirante.models.switcher.Switcher;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("switches")
public class SwitchController {

    @Autowired
    private SwitchRepository switchRepository;
    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid SwitcherDTO switcherDTO) {
        switchRepository.save(new Switcher(switcherDTO));
    }
    @GetMapping
    public List<DataListingSwitch> getAllSwitches() {
        return switchRepository.findAllByActiveTrue().stream().map(DataListingSwitch::new).toList();
    }
    @PutMapping
    @Transactional
    public void updateSwitch(@RequestBody @Valid DataUpdatingSwitch data) {
        var switches = switchRepository.getReferenceById(data.id());
        switches.updateInfo(data);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable(value = "id") Long id){
        var switches = switchRepository.getReferenceById(id);
        switches.delete();
    }
}

package com.pmoc.mirante.controller;

import com.pmoc.mirante.dtos.UserDTO;
import com.pmoc.mirante.user.DataListingUser;
import com.pmoc.mirante.user.DataUpdatingUser;
import com.pmoc.mirante.user.User;
import com.pmoc.mirante.user.UserRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("users")
public class UserController {
    @Autowired
    private UserRepository repository;
    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid UserDTO data) {
        repository.save(new User(data));
    }
    @GetMapping
    public List<DataListingUser> getAllUsers() {
        return repository.findAllByActiveTrue().stream().map(DataListingUser::new).toList();
    }
    @PutMapping
    @Transactional
    public void updateUser(@RequestBody @Valid DataUpdatingUser dataUpdatingUser) {
        var user = repository.getReferenceById(dataUpdatingUser.id());
        user.updateInfo(dataUpdatingUser);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id) {
        var user = repository.getReferenceById(id);
        user.delete();
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<Object> deleteUser(@PathVariable(value = "id") UUID id){
//        Optional<User> userModelOptional = userServices.findById(id);
//        if(!userModelOptional.isPresent()) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
//        }
//        userServices.delete(userModelOptional.get());
//        return ResponseEntity.status(HttpStatus.OK).body("User deleted successfully!");
//    }
}

package com.pmoc.mirante.services;

import com.pmoc.mirante.user.DataListingUser;
import com.pmoc.mirante.user.User;
import com.pmoc.mirante.user.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServices {
    final UserRepository repository;
    public UserServices(UserRepository repository) {
        this.repository = repository;
    }
    @Transactional
    public User save(User userModel) {
        return repository.save(userModel);
    }

    public List<DataListingUser> findAll() {
        return repository.findAllByActiveTrue().stream().map(DataListingUser::new).toList();
    }

//    public Optional<User> findById(UUID id){
//        return repository.findById();
//    }
    @Transactional
    public void delete(User userModel) {
        userModel.delete();
    }
}

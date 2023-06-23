package com.pmoc.mirante.controller;

import com.pmoc.mirante.config.security.AuthDTO;
import com.pmoc.mirante.config.security.TokenJWT;
import com.pmoc.mirante.config.security.TokenService;
import com.pmoc.mirante.models.user.UserModel;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthController {
    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid AuthDTO authDTO){
        var AuthToken = new UsernamePasswordAuthenticationToken(authDTO.username(), authDTO.password());
        var authentication = manager.authenticate(AuthToken);
        var tokenJWT = tokenService.generateToken((UserModel) authentication.getPrincipal());

        return ResponseEntity.status(HttpStatus.OK).body(new TokenJWT(tokenJWT));
    }
}

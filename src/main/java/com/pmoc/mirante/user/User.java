package com.pmoc.mirante.user;

import com.pmoc.mirante.dtos.UserDTO;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "users")
@Entity(name = "User")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String last_name;
    private String contact;
    private String company;
    private String contact_company;
    private Boolean active;

    public User(UserDTO data) {
        this.active = true;
        this.name = data.name();
        this.last_name = data.last_name();
        this.contact = data.contact();
        this.company = data.company();
        this.contact_company = data.contact_company();
    }
    public void updateInfo(@Valid DataUpdatingUser dados) {

        if(dados.name() != null) {
            this.name = dados.name();
        }
        if(dados.last_name() != null) {
            this.last_name = dados.last_name();
        }
        if(dados.company() != null) {
            this.company = dados.company();
        }
        if(dados.contact() != null) {
            this.contact = dados.contact();
        }
        if(dados.contact_company() != null) {
            this.contact_company = dados.contact_company();
        }
    }

    public void delete() {
        this.active = false;
    }
}

package com.pmoc.mirante.exaustor;

import com.pmoc.mirante.dtos.ExaustorDTO;
import com.pmoc.mirante.enums.Categories;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "exaustores")
@Entity(name = "Exaustor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Exaustor {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tag;
    private String marca;
    private String modelo;
    private Categories category;
    private Boolean active;

    public Exaustor(ExaustorDTO data) {
        this.active = true;
        this.tag = data.tag();
        this.marca = data.marca();
        this.modelo = data.modelo();
        this.category = data.category();
    }
    public void updateInfo(@Valid DataUpdatingExaustor dados) {

        if(dados.tag() != null) {
            this.tag = dados.tag();
        }
        if(dados.marca() != null) {
            this.marca = dados.marca();
        }
        if(dados.modelo() != null) {
            this.modelo = dados.modelo();
        }
        if(dados.category() != null) {
            this.category = dados.category();
        }
    }
    public void delete() {

        this.active = false;
    }
}

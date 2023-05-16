package com.pmoc.mirante.switcher;

import com.pmoc.mirante.dtos.SwitcherDTO;
import com.pmoc.mirante.enums.Categories;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "switch")
@Entity(name = "Switcher")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Switcher {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tag;
    private String marca;
    private String modelo;
    private int qtd_portas;
    private Categories category;
    private Boolean active;
    public Switcher(SwitcherDTO data) {
        this.active = true;
        this.tag = data.tag();
        this.marca = data.marca();
        this.modelo = data.modelo();
        this.qtd_portas = data.qtd_portas();
        this.category = data.category();
    }
    public void updateInfo(@Valid DataUpdatingSwitch dados) {

        if(dados.tag() != null) {
            this.tag = dados.tag();
        }
        if(dados.marca() != null) {
            this.marca = dados.marca();
        }
        if(dados.modelo() != null) {
            this.modelo = dados.modelo();
        }
        if(dados.qtd_portas() > 0) {
            this.qtd_portas = dados.qtd_portas();
        }
        if(dados.category() != null) {
            this.category = dados.category();
        }
    }
    public void delete() {

        this.active = false;
    }
}

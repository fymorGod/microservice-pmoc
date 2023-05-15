package com.pmoc.mirante.arcondicionado;

import com.pmoc.mirante.dtos.ArCondicionadoDTO;
import com.pmoc.mirante.enums.Categories;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "arcondicionados")
@Entity(name = "ArCondicionado")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ArCondicionado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tag;
    private String marca;
    private String modelo;
    private int potencia;
    private int tensao;
    @Enumerated(EnumType.STRING)
    private Categories category;
    private Boolean active;

    public ArCondicionado(ArCondicionadoDTO arCondicionadoDTO) {

        this.active = true;
        this.tag = arCondicionadoDTO.tag();
        this.marca = arCondicionadoDTO.marca();
        this.modelo = arCondicionadoDTO.modelo();
        this.potencia = arCondicionadoDTO.potencia();
        this.tensao = arCondicionadoDTO.tensao();
        this.category = arCondicionadoDTO.category();
    }
    public void updateInfo(DataUpdatingArCondicionados dados) {

        if(dados.tag() != null) {
            this.tag = dados.tag();
        }
        if(dados.marca() != null) {
            this.marca = dados.marca();
        }
        if(dados.modelo() != null) {
            this.modelo = dados.modelo();
        }
        if(dados.potencia() <= 0) {
            this.potencia = dados.potencia();
        }
        if(dados.tensao() <= 0) {
            this.tensao = dados.tensao();
        }
        if(dados.category() != null) {
            this.category = dados.category();
        }
    }
    public void delete() {

        this.active = false;
    }

}

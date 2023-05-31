package com.pmoc.mirante.models.arcondicionado;

import com.pmoc.mirante.dtos.ArCondicionadoDTO;
import com.pmoc.mirante.enums.Categories;
import com.pmoc.mirante.models.gerais.Gerais;
import jakarta.persistence.*;
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
    @Embedded
    private Gerais gerais;
    private int potencia;
    private int tensao;
    @Enumerated(EnumType.STRING)
    private Categories category;
    private Boolean active;

    public ArCondicionado(ArCondicionadoDTO arCondicionadoDTO) {

        this.active = true;
        this.gerais = new Gerais(arCondicionadoDTO.gerais());
        this.potencia = arCondicionadoDTO.potencia();
        this.tensao = arCondicionadoDTO.tensao();
        this.category = arCondicionadoDTO.category();
    }
    public void updateInfo(DataUpdatingArCondicionados dados) {

        if(dados.gerais() != null) {
            this.gerais.updateInfo(dados.gerais());
        }
        if(dados.potencia() > 0) {
            this.potencia = dados.potencia();
        }
        if(dados.tensao() > 0) {
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

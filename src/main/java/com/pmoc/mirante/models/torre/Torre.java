package com.pmoc.mirante.models.torre;

import com.pmoc.mirante.dtos.TorreDTO;
import com.pmoc.mirante.enums.Categories;
import com.pmoc.mirante.enums.TiposTorre;
import com.pmoc.mirante.models.gerais.Gerais;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "torres")
@Entity(name = "Torre")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Torre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private Gerais gerais;
    @Enumerated(EnumType.STRING)
    private Categories category;
    @Enumerated(EnumType.STRING)
    private TiposTorre tipos_estrutura;
    private Boolean active;
    private Boolean aterramento;
    private Double altura;

    public Torre(TorreDTO data){
        this.active = true;
        this.altura = data.altura();
        this.aterramento = data.aterramento();
        this.gerais = new Gerais(data.gerais());
        this.category = data.category();
        this.tipos_estrutura = data.tipos_estrutura();
    }
    public void updateInfo(DataUpdatingTorre dados) {

        if(dados.gerais() != null) {
            this.gerais.updateInfo(dados.gerais());
        }
        if(dados.aterramento() != null) {
            this.aterramento = dados.aterramento();
        }
        if(dados.altura() != null) {
            this.altura = dados.altura();
        }
        if(dados.tipos_estrutura() != null) {
            this.tipos_estrutura = dados.tipos_estrutura();
        }
        if(dados.category() != null) {
            this.category = dados.category();
        }
    }
    public void delete() {

        this.active = false;
    }
}

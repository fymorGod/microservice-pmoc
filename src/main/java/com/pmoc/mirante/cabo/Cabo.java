package com.pmoc.mirante.cabo;

import com.pmoc.mirante.dtos.CaboDTO;
import com.pmoc.mirante.enums.Categories;
import com.pmoc.mirante.enums.TiposCabo;
import com.pmoc.mirante.exaustor.DataUpdatingExaustor;
import com.pmoc.mirante.gerais.Gerais;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "cabos")
@Entity(name = "Cabo")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cabo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private Gerais gerais;
    @Enumerated(EnumType.STRING)
    private Categories category;
    @Enumerated(EnumType.STRING)
    private TiposCabo tipos_cabo;
    private Double tamanho;
    private Boolean active;

    public Cabo(CaboDTO data){
        this.active = true;
        this.gerais = new Gerais(data.gerais());
        this.category = data.category();
        this.tamanho = data.tamanho();
        this.tipos_cabo = data.tipos_cabo();
    }
    public void updateInfo(@Valid DataUpdatingCabo dados) {

        if(dados.gerais() != null) {
            this.gerais.updateInfo(dados.gerais());
        }
        if(dados.category() != null) {
            this.category = dados.category();
        }
        if(dados.tamanho() != null) {
            this.tamanho = dados.tamanho();
        }
        if(dados.tipos_cabo() != null) {
            this.tipos_cabo = dados.tipos_cabo();
        }
    }
    public void delete() {

        this.active = false;
    }
}

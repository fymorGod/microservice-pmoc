package com.pmoc.mirante.models.dps;

import com.pmoc.mirante.dtos.DPSDTO;
import com.pmoc.mirante.enums.Categories;
import com.pmoc.mirante.enums.ClasseDPS;
import com.pmoc.mirante.models.gerais.Gerais;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "dps")
@Entity(name = "DPS")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class DPS {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private Gerais gerais;
    @Enumerated(EnumType.STRING)
    private Categories category;
    @Enumerated(EnumType.STRING)
    private ClasseDPS classe;
    private int corrente_maxima;
    private Boolean active;

    public DPS(DPSDTO data){
        this.active = true;
        this.gerais = new Gerais(data.gerais());
        this.category = data.category();
        this.corrente_maxima = data.corrente_maxima();
        this.classe = data.classe();
    }

    public void updateInfo(@Valid DataUpdatingDPS dados) {

        if(dados.gerais() != null) {
            this.gerais.updateInfo(dados.gerais());
        }
        if(dados.classe() != null) {
            this.classe = dados.classe();
        }
        if(dados.corrente_maxima() > 0) {
            this.corrente_maxima = dados.corrente_maxima();
        }
        if(dados.category() != null) {
            this.category = dados.category();
        }
    }
    public void delete() {

        this.active = false;
    }
}

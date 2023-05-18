package com.pmoc.mirante.disjuntor;

import com.pmoc.mirante.dtos.DisjuntorDTO;
import com.pmoc.mirante.enums.Categories;
import com.pmoc.mirante.gerais.Gerais;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "disjuntores")
@Entity(name = "Disjuntor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Disjuntor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private Gerais gerais;
    private int corrente_maxima;
    @Enumerated(EnumType.STRING)
    private Categories category;
    private Boolean active;
    public Disjuntor(DisjuntorDTO data) {

        this.active = true;
        this.gerais = new Gerais(data.gerais());
        this.category = data.category();
        this.corrente_maxima = data.corrente_maxima();
    }
    public void updateInfo(DataUpdatingDisjuntor dados) {

        if(dados.gerais() != null) {
            this.gerais.updateInfo(dados.gerais());
        }
        if(dados.corrente_maxima() <= 0) {
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

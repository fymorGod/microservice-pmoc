package com.pmoc.mirante.exaustor;

import com.pmoc.mirante.dtos.ExaustorDTO;
import com.pmoc.mirante.enums.Categories;
import com.pmoc.mirante.gerais.Gerais;
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
    @Embedded
    private Gerais gerais;
    private Categories category;
    private Boolean active;

    public Exaustor(ExaustorDTO data) {
        this.active = true;
        this.gerais = new Gerais(data.gerais());
        this.category = data.category();
    }
    public void updateInfo(@Valid DataUpdatingExaustor dados) {

        if(dados.gerais() != null) {
            this.gerais.updateInfo(dados.gerais());
        }
        if(dados.category() != null) {
            this.category = dados.category();
        }
    }
    public void delete() {

        this.active = false;
    }
}

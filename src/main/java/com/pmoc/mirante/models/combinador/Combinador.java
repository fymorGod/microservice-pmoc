package com.pmoc.mirante.models.combinador;

import com.pmoc.mirante.dtos.CombinadorDTO;
import com.pmoc.mirante.enums.Categories;
import com.pmoc.mirante.models.gerais.Gerais;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "combinadores")
@Entity(name = "Combinador")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Combinador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private Gerais gerais;
    @Enumerated(EnumType.STRING)
    private Categories category;
    private Boolean active;

    public Combinador(CombinadorDTO data){
        this.active = true;
        this.gerais = new Gerais(data.gerais());
        this.category = data.category();
    }
    public void updateInfo(@Valid DataUpdatingCombinador dados) {

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

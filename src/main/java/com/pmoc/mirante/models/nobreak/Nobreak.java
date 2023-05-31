package com.pmoc.mirante.models.nobreak;

import com.pmoc.mirante.dtos.NobrekDTO;
import com.pmoc.mirante.enums.Categories;
import com.pmoc.mirante.models.gerais.Gerais;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "nobreaks")
@Entity(name = "Nobreak")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Nobreak {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private Gerais gerais;
    private int tensao_entrada;
    private int tensao_saida;
    private Categories category;
    private Boolean active;
    public Nobreak(NobrekDTO data){

        this.active = true;
        this.gerais = new Gerais(data.gerais());
        this.tensao_entrada = data.tensao_entrada();
        this.tensao_saida = data.tensao_saida();
        this.category = data.category();
    }
    public void updateInfo(@Valid DataUpdatingNobreak dados) {

        if(dados.gerais() != null) {
            this.gerais.updateInfo(dados.gerais());
        }
        if(dados.tensao_entrada() >= 0) {
            this.tensao_entrada = dados.tensao_entrada();
        }
        if(dados.tensao_saida() >= 0) {
            this.tensao_saida = dados.tensao_saida();
        }
    }

    public void delete() {

        this.active = false;
    }
}

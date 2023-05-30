package com.pmoc.mirante.parabolica;

import com.pmoc.mirante.dtos.ParabolicaDTO;
import com.pmoc.mirante.enums.Categories;
import com.pmoc.mirante.gerais.Gerais;
import com.pmoc.mirante.receptor.Receptor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "parabolicas")
@Entity(name = "Parabolica")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Parabolica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private Gerais gerais;
    private Double diametro;
    private String satelite;

    @OneToMany(mappedBy = "parabolica")
    private List<Receptor> receptor;

    @Enumerated(EnumType.STRING)
    private Categories category;
    private Boolean active;

    public Parabolica(ParabolicaDTO parabolicaDTO){
        this.active = true;
        this.gerais = new Gerais(parabolicaDTO.gerais());
        this.diametro = parabolicaDTO.diametro();
        this.satelite = parabolicaDTO.satelite();
        this.receptor = parabolicaDTO.receptor();
        this.category = parabolicaDTO.category();
    }

    public void updateInfo(DataUpdatingParabolica dados) {
        if(dados.gerais() != null) {
            this.gerais.updateInfo(dados.gerais());
        }
        if(dados.diametro() != null){
           this.diametro = dados.diametro();
        }
        if(dados.satelite() != null){
           this.satelite = dados.satelite();
        }
        if(dados.receptor() != null){
            this.receptor = dados.receptor();
        }
        if(dados.category() != null) {
            this.category = dados.category();
        }
    }
    public void delete() {

        this.active = false;
    }
}

package com.pmoc.mirante.models.antena;

import com.pmoc.mirante.dtos.AntenaDTO;
import com.pmoc.mirante.enums.Categories;
import com.pmoc.mirante.enums.TiposAntena;
import com.pmoc.mirante.models.gerais.Gerais;
import com.pmoc.mirante.models.transmissor.Transmissor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "antenas")
@Entity(name = "Antena")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Antena {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private Gerais gerais;
    @Enumerated(EnumType.STRING)
    private Categories category;
    private String gain;
    private Double fendas;
    @Enumerated(EnumType.STRING)
    private TiposAntena tiposAntena;
    private Double posicao_torre;
    private String vr;
    private Boolean active;
    @OneToMany(mappedBy = "transmissor")
    private List<Transmissor> transmissor;

    public Antena(AntenaDTO data){
        this.active = true;
        this.vr = data.vr();
        this.posicao_torre = data.posicao_torre();
        this.gain = data.gain();
        this.category = data.category();
        this.gerais = new Gerais(data.gerais());
        this.fendas = data.fendas();
        this.tiposAntena = data.tipos_antena();
        this.transmissor = data.transmissor();
    }

    public void updateInfo(DataUpdatingAntena dados) {
        if(dados.gerais() != null) {
            this.gerais.updateInfo(dados.gerais());
        }
        if(dados.gain() != null){
            this.gain = dados.gain();
        }
        if(dados.posicao_torre() != null){
            this.posicao_torre = dados.posicao_torre();
        }
        if(dados.vr() != null){
            this.vr = dados.vr();
        }
        if(dados.fendas() != null){
            this.fendas = dados.fendas();
        }
        if(dados.tipos_antena() != null){
            this.tiposAntena = dados.tipos_antena();
        }
        if(dados.category() != null) {
            this.category = dados.category();
        }
        if(dados.transmissor() != null){
            this.transmissor = dados.transmissor();
        }
    }
    public void delete() {

        this.active = false;
    }

}

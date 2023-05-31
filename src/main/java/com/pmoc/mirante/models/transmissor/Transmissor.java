package com.pmoc.mirante.models.transmissor;

import com.pmoc.mirante.models.antena.Antena;
import com.pmoc.mirante.dtos.TransmissorDTO;
import com.pmoc.mirante.enums.Categories;
import com.pmoc.mirante.models.gerais.Gerais;
import com.pmoc.mirante.models.receptor.Receptor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "transmissores")
@Entity(name = "Transmissor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Transmissor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private Gerais gerais;
    @Enumerated(EnumType.STRING)
    private Categories category;
    private Boolean active;
    private Double programmed;
    private Double canal_fisico;
    private Double canal_virtual;
    @OneToOne(cascade = CascadeType.ALL)
    private Receptor receptor;
    @ManyToOne
    @JoinColumn(name = "antena_id", nullable = false)
    private Antena antena;

    public Transmissor(TransmissorDTO data){
        this.active = true;
        this.gerais = new Gerais(data.gerais());
        this.category = data.category();
        this.canal_fisico = data.canal_fisico();
        this.canal_virtual = data.canal_virtual();
        this.antena = data.antena();
    }
    public void updateInfo(DadosUpdatingTransmissor dados) {
        if(dados.gerais() != null) {
            this.gerais.updateInfo(dados.gerais());
        }
        if(dados.category() != null) {
            this.category = dados.category();
        }
        if(dados.antena() != null){
            this.antena = dados.antena();
        }
        if(dados.canal_fisico() != null){
            this.canal_fisico = dados.canal_fisico();
        }
        if(dados.canal_virtual() != null){
            this.canal_virtual = dados.canal_virtual();
        }
        if(dados.programmed() != null){
            this.programmed = dados.programmed();
        }
        if(dados.receptor() != null){
            this.receptor = dados.receptor();
        }
    }
    public void delete() {

        this.active = false;
    }
}

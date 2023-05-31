package com.pmoc.mirante.models.receptor;

import com.pmoc.mirante.dtos.ReceptorDTO;
import com.pmoc.mirante.enums.Categories;
import com.pmoc.mirante.models.gerais.Gerais;
import com.pmoc.mirante.models.parabolica.Parabolica;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "receptores")
@Entity(name = "Receptor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Receptor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private Gerais gerais;
    private int frequency;
    private int symbol_rate;
    @ManyToOne
    @JoinColumn(name = "parabolica_id", nullable = false)
    private Parabolica parabolica;

    @Enumerated(EnumType.STRING)
    private Categories category;
    private Boolean active;

    public Receptor(ReceptorDTO data){
        this.active = true;
        this.gerais = new Gerais(data.gerais());
        this.frequency = data.frequency();
        this.symbol_rate = data.symbol_rate();
        this.parabolica = data.parabolica();
        this.category = data.category();
    }
    public void updateInfo(DataUpdatingReceptor dados){
        if(dados.gerais() != null) {
            this.gerais.updateInfo(dados.gerais());
        }
        if(dados.category() != null) {
            this.category = dados.category();
        }
        if(dados.frequency() > 0){
            this.frequency = dados.frequency();
        }
        if(dados.symbol_rate() >0 ){
            this.symbol_rate = dados.symbol_rate();
        }
        if(dados.parabolica() != null){
            this.parabolica = dados.parabolica();
        }
    }
    public void delete() {

        this.active = false;
    }

}

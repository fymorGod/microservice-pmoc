package com.pmoc.mirante.receptor;

import com.pmoc.mirante.dtos.ReceptorDTO;
import com.pmoc.mirante.enums.Categories;
import com.pmoc.mirante.gerais.Gerais;
import com.pmoc.mirante.parabolica.Parabolica;
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

}

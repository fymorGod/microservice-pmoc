package com.pmoc.mirante.models.telemetria;

import com.pmoc.mirante.dtos.TelemetriaDTO;
import com.pmoc.mirante.enums.Categories;
import com.pmoc.mirante.models.gerais.Gerais;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "telemetrias")
@Entity(name = "Telemetria")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Telemetria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private Gerais gerais;
    private Categories category;
    private Boolean active;

    public Telemetria(TelemetriaDTO data){
        this.active = true;
        this.gerais = new Gerais(data.gerais());
        this.category = data.category();
    }
    public void updateInfo(@Valid DataUpdatingTelemetria dados) {

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

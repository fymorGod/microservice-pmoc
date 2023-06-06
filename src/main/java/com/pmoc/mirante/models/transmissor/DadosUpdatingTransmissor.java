package com.pmoc.mirante.models.transmissor;

import com.pmoc.mirante.models.antena.AntenaModel;
import com.pmoc.mirante.enums.Categories;
import com.pmoc.mirante.models.gerais.DadosGerais;
import com.pmoc.mirante.models.receptor.ReceptorModel;
import jakarta.validation.constraints.NotNull;

public record DadosUpdatingTransmissor(
        @NotNull
        Long id,
        DadosGerais gerais,
        Categories category,
        AntenaModel antena,
        ReceptorModel receptor,
        Double canal_fisico,
        Double canal_virtual,
        Double programmed

) {
}

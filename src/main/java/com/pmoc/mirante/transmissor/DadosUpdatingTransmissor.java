package com.pmoc.mirante.transmissor;

import com.pmoc.mirante.antena.Antena;
import com.pmoc.mirante.enums.Categories;
import com.pmoc.mirante.gerais.DadosGerais;
import com.pmoc.mirante.receptor.Receptor;
import jakarta.validation.constraints.NotNull;

public record DadosUpdatingTransmissor(
        @NotNull
        Long id,
        DadosGerais gerais,
        Categories category,
        Antena antena,
        Receptor receptor,
        Double canal_fisico,
        Double canal_virtual,
        Double programmed

) {
}

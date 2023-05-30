package com.pmoc.mirante.dtos;

import com.pmoc.mirante.antena.Antena;
import com.pmoc.mirante.enums.Categories;
import com.pmoc.mirante.gerais.DadosGerais;
import com.pmoc.mirante.receptor.Receptor;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record TransmissorDTO(
        @NotNull
        @Valid
        DadosGerais gerais,
        @NotNull
        Categories category,
        @NotNull
        Receptor receptor,
        @NotNull
        Antena antena,
        @NotNull
        Double programmed,
        @NotNull
        Double canal_fisico,
        @NotNull
        Double canal_virtual
) {
}

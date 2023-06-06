package com.pmoc.mirante.dtos;

import com.pmoc.mirante.models.antena.AntenaModel;
import com.pmoc.mirante.enums.Categories;
import com.pmoc.mirante.models.gerais.DadosGerais;
import com.pmoc.mirante.models.receptor.ReceptorModel;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record TransmissorDTO(
        @NotNull
        @Valid
        DadosGerais gerais,
        @NotNull
        Categories category,
        @NotNull
        ReceptorModel receptor,
        @NotNull
        AntenaModel antena,
        @NotNull
        Double programmed,
        @NotNull
        Double canal_fisico,
        @NotNull
        Double canal_virtual
) {
}

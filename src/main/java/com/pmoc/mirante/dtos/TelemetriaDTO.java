package com.pmoc.mirante.dtos;

import com.pmoc.mirante.enums.Categories;
import com.pmoc.mirante.models.gerais.DadosGerais;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record TelemetriaDTO(
        @NotNull
        @Valid
        DadosGerais gerais,
        @NotNull
        Categories category
) {
}

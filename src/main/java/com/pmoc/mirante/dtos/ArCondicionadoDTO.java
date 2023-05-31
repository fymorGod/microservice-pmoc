package com.pmoc.mirante.dtos;

import com.pmoc.mirante.enums.Categories;
import com.pmoc.mirante.models.gerais.DadosGerais;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record ArCondicionadoDTO(
        @NotNull
        @Valid
        DadosGerais gerais,
        @NotNull
        int potencia,
        @NotNull
        int tensao,
        @NotNull
        Categories category
) {
}

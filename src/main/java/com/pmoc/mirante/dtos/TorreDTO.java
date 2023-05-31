package com.pmoc.mirante.dtos;

import com.pmoc.mirante.enums.Categories;
import com.pmoc.mirante.enums.TiposTorre;
import com.pmoc.mirante.models.gerais.DadosGerais;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TorreDTO(
        @NotNull
        @Valid
        DadosGerais gerais,
        @NotBlank
        Double altura,
        @NotBlank
        Boolean aterramento,
        @NotNull
        Categories category,
        @NotNull
        TiposTorre tipos_estrutura
) {
}

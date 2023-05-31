package com.pmoc.mirante.dtos;

import com.pmoc.mirante.enums.Categories;
import com.pmoc.mirante.models.gerais.DadosGerais;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record NobrekDTO(
        @NotNull
        @Valid
        DadosGerais gerais,
        @NotBlank
        int tensao_entrada,
        @NotBlank
        int tensao_saida,
        @NotNull
        Categories category
) {
}

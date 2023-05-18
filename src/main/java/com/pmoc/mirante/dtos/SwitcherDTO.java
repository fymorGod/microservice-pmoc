package com.pmoc.mirante.dtos;

import com.pmoc.mirante.enums.Categories;
import com.pmoc.mirante.gerais.DadosGerais;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SwitcherDTO(
        @NotNull
        @Valid
        DadosGerais gerais,
        @NotNull
        int qtd_portas,
        @NotNull
        Categories category
) {
}

package com.pmoc.mirante.exaustor;

import com.pmoc.mirante.enums.Categories;
import com.pmoc.mirante.gerais.DadosGerais;
import jakarta.validation.constraints.NotNull;

public record DataUpdatingExaustor(
        @NotNull
        Long id,
        DadosGerais gerais,
        Categories category
) {
}

package com.pmoc.mirante.models.combinador;

import com.pmoc.mirante.enums.Categories;
import com.pmoc.mirante.models.gerais.DadosGerais;
import jakarta.validation.constraints.NotNull;

public record DataUpdatingCombinador(
        @NotNull
        Long id,
        DadosGerais gerais,
        Categories category
) {
}

package com.pmoc.mirante.combinador;

import com.pmoc.mirante.enums.Categories;
import com.pmoc.mirante.gerais.DadosGerais;
import jakarta.validation.constraints.NotNull;

public record DataUpdatingCombinador(
        @NotNull
        Long id,
        DadosGerais gerais,
        Categories category
) {
}

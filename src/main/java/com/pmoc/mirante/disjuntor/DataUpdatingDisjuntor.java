package com.pmoc.mirante.disjuntor;

import com.pmoc.mirante.enums.Categories;
import com.pmoc.mirante.gerais.DadosGerais;
import jakarta.validation.constraints.NotNull;

public record DataUpdatingDisjuntor(
        @NotNull
        Long id,
        DadosGerais gerais,
        int corrente_maxima,
        Categories category
) {
}

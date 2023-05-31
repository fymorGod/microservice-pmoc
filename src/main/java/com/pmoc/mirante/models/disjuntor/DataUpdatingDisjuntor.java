package com.pmoc.mirante.models.disjuntor;

import com.pmoc.mirante.enums.Categories;
import com.pmoc.mirante.models.gerais.DadosGerais;
import jakarta.validation.constraints.NotNull;

public record DataUpdatingDisjuntor(
        @NotNull
        Long id,
        DadosGerais gerais,
        int corrente_maxima,
        Categories category
) {
}

package com.pmoc.mirante.dps;

import com.pmoc.mirante.enums.Categories;
import com.pmoc.mirante.enums.ClasseDPS;
import com.pmoc.mirante.gerais.DadosGerais;
import jakarta.validation.constraints.NotNull;

public record DataUpdatingDPS(
        @NotNull
        Long id,
        DadosGerais gerais,
        Categories category,
        ClasseDPS classe,
        int corrente_maxima
) {
}

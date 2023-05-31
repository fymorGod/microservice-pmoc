package com.pmoc.mirante.models.cabo;

import com.pmoc.mirante.enums.Categories;
import com.pmoc.mirante.enums.TiposCabo;
import com.pmoc.mirante.models.gerais.DadosGerais;
import jakarta.validation.constraints.NotNull;

public record DataUpdatingCabo(
        @NotNull
        Long id,
        DadosGerais gerais,
        Categories category,
        TiposCabo tipos_cabo,
        Double tamanho
) {
}

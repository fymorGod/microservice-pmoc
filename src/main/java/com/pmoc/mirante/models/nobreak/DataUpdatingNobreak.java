package com.pmoc.mirante.models.nobreak;

import com.pmoc.mirante.enums.Categories;
import com.pmoc.mirante.models.gerais.DadosGerais;
import jakarta.validation.constraints.NotNull;

public record DataUpdatingNobreak(
        @NotNull
        Long id,
        DadosGerais gerais,
        int tensao_entrada,
        int tensao_saida,
        Categories category
) {
}

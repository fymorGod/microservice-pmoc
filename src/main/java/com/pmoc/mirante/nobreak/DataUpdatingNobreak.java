package com.pmoc.mirante.nobreak;

import com.pmoc.mirante.enums.Categories;
import com.pmoc.mirante.gerais.DadosGerais;
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

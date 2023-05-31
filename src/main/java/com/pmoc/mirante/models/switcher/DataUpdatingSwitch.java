package com.pmoc.mirante.models.switcher;

import com.pmoc.mirante.enums.Categories;
import com.pmoc.mirante.models.gerais.DadosGerais;
import jakarta.validation.constraints.NotNull;

public record DataUpdatingSwitch(
        @NotNull
        Long id,
        DadosGerais gerais,
        int qtd_portas,
        Categories category
) {
}

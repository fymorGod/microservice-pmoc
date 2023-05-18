package com.pmoc.mirante.switcher;

import com.pmoc.mirante.enums.Categories;
import com.pmoc.mirante.gerais.DadosGerais;
import jakarta.validation.constraints.NotNull;

public record DataUpdatingSwitch(
        @NotNull
        Long id,
        DadosGerais gerais,
        int qtd_portas,
        Categories category
) {
}

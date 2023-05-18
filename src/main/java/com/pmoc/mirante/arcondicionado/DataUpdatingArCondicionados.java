package com.pmoc.mirante.arcondicionado;

import com.pmoc.mirante.enums.Categories;
import com.pmoc.mirante.gerais.DadosGerais;
import jakarta.validation.constraints.NotNull;

public record DataUpdatingArCondicionados(
        @NotNull
        Long id,
        DadosGerais gerais,
        int potencia,
        int tensao,
        Categories category) {
}

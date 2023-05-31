package com.pmoc.mirante.models.arcondicionado;

import com.pmoc.mirante.enums.Categories;
import com.pmoc.mirante.models.gerais.DadosGerais;
import jakarta.validation.constraints.NotNull;

public record DataUpdatingArCondicionados(
        @NotNull
        Long id,
        DadosGerais gerais,
        int potencia,
        int tensao,
        Categories category) {
}

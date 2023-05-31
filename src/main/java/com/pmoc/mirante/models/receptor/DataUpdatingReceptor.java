package com.pmoc.mirante.models.receptor;

import com.pmoc.mirante.enums.Categories;
import com.pmoc.mirante.models.gerais.DadosGerais;
import com.pmoc.mirante.models.parabolica.Parabolica;
import jakarta.validation.constraints.NotNull;

public record DataUpdatingReceptor(
        @NotNull
        Long id,
        DadosGerais gerais,
        Categories category,
        int frequency,
        int symbol_rate,
        Parabolica parabolica
) {
}

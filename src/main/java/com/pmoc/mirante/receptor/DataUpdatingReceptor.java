package com.pmoc.mirante.receptor;

import com.pmoc.mirante.enums.Categories;
import com.pmoc.mirante.gerais.DadosGerais;
import com.pmoc.mirante.parabolica.Parabolica;
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

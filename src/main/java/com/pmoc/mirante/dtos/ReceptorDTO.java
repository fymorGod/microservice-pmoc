package com.pmoc.mirante.dtos;

import com.pmoc.mirante.enums.Categories;
import com.pmoc.mirante.models.gerais.DadosGerais;
import com.pmoc.mirante.models.parabolica.Parabolica;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record ReceptorDTO(
        @NotNull
        @Valid
        DadosGerais gerais,
        @NotNull
        int frequency,
        @NotNull
        int symbol_rate,
        @NotNull
        Parabolica parabolica,
        @NotNull
        Categories category
) {
}

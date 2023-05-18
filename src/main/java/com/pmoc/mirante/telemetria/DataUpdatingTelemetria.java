package com.pmoc.mirante.telemetria;

import com.pmoc.mirante.enums.Categories;
import com.pmoc.mirante.gerais.DadosGerais;
import jakarta.validation.constraints.NotNull;

public record DataUpdatingTelemetria(
        @NotNull
        Long id,
        DadosGerais gerais,
        Categories category
) {
}

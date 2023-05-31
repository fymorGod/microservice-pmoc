package com.pmoc.mirante.models.telemetria;

import com.pmoc.mirante.enums.Categories;
import com.pmoc.mirante.models.gerais.DadosGerais;
import jakarta.validation.constraints.NotNull;

public record DataUpdatingTelemetria(
        @NotNull
        Long id,
        DadosGerais gerais,
        Categories category
) {
}

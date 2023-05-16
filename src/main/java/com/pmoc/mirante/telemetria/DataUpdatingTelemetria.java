package com.pmoc.mirante.telemetria;

import com.pmoc.mirante.enums.Categories;
import jakarta.validation.constraints.NotNull;

public record DataUpdatingTelemetria(
        @NotNull
        Long id,
        String tag,
        String marca,
        String modelo,
        Categories category
) {
}

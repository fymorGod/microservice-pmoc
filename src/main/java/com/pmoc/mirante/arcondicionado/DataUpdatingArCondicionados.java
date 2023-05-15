package com.pmoc.mirante.arcondicionado;

import com.pmoc.mirante.enums.Categories;
import jakarta.validation.constraints.NotNull;

public record DataUpdatingArCondicionados(
        @NotNull
        Long id,
        String tag,
        String marca,
        String modelo,
        int potencia,
        int tensao,
        Categories category) {
}

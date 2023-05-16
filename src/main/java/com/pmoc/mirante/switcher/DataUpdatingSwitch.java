package com.pmoc.mirante.switcher;

import com.pmoc.mirante.enums.Categories;
import jakarta.validation.constraints.NotNull;

public record DataUpdatingSwitch(
        @NotNull
        Long id,
        String tag,
        String marca,
        String modelo,
        int qtd_portas,
        Categories category
) {
}

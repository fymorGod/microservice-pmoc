package com.pmoc.mirante.exaustor;

import com.pmoc.mirante.enums.Categories;
import jakarta.validation.constraints.NotNull;

public record DataUpdatingExaustor(
        @NotNull
        Long id,
        String tag,
        String marca,
        String modelo,
        Categories category
) {
}
